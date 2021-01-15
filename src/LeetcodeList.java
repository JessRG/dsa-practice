import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LeetcodeList {

    // Declaring ArrayList object to help solve some problems
    private final ArrayList<Integer> tree;
    private final List<List<Integer>> pascalsT;
    private final Scanner scan;

    LeetcodeList() {
        this.tree = new ArrayList<>();
        this.pascalsT = new ArrayList<>();
        scan = new Scanner(System.in);
    }

    // selectionSort method
    public int[] sortArray(int[] nums) {

        // loop through nums
        int idx = 0, smallest = -1;
        for(int i = 0; i < nums.length; i++) {
            idx = 0;
            smallest = nums[i];
            for(int j = i; j < nums.length; j++) {
                if(nums[j] < smallest) {
                    smallest = nums[j];
                    idx = j;
                }
            }
            if(smallest < nums[i]) {
                int temp = nums[i];
                nums[i] = smallest;
                nums[idx] = temp;
            }
        }
        return nums;
    }

    // bubbleSort method
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);

        System.out.println(Arrays.toString(nums));
    }

    // mergeSort method
    // Added this method to practice with using mergeSort
    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        int[] left;
        int[] right;

        // determine size of left and right array by number of array elements
        if(n < 2) {
            return nums;
        } else if(n % 2 == 0) {
            left = new int[n/2];
            right = new int[n/2];
        } else {
            left = new int[n/2];
            right = new int[n/2+1];
        }

        // fill in both the left and right arrays
        for(int i = 0; i < n; i++) {
            if(i < n/2) {
                left[i] = nums[i];
            } else {
                right[i - n/2] = nums[i];
            }
        }

        // recursively split and merge left and right arrays
        left = mergeSort(left);
        right = mergeSort(right);

        // merge subarrays
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        // declare result array which is the size of left and right together
        int [] res = new int[left.length + right.length];

        int leftIdx = 0;
        int rightIdx = 0;
        int idx = 0;
        // traverse through both left and right arrays and check which
        // elements should be set to the front of the result array
        while(leftIdx < left.length && rightIdx < right.length) {
            if(left[leftIdx] < right[rightIdx]) {
                res[idx++] = left[leftIdx++];
            } else {
                res[idx++] = right[rightIdx++];
            }
        }

        // add leftover elements from left
        while(leftIdx < left.length) {
            res[idx++] = left[leftIdx++];
        }

        // add leftover elements from right
        while(rightIdx < right.length) {
            res[idx++] = right[rightIdx++];
        }

        return res;
    }

    // Binary Search method
    public boolean binarySearch(int v, int[] nums, int low, int high) {
        if(low > high) {
            System.out.println("Not found");
            return false;
        }

        int mid = (low + high) / 2;
        if(v == nums[mid]) {
            System.out.printf("Found it at %d!\n", mid);
            return true;
        } else if(v < nums[mid]) {
            return binarySearch(v, nums, low, mid-1);
        } else {
            return binarySearch(v, nums, mid+1, high);
        }
    }

    // Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                result[0] = myMap.get(nums[i]);
                result[1] = i;
                break;
            }
            myMap.put(target-nums[i], i); // store complement as key, index as value
        }
        return result;
    }

    // Longest Common Prefix
    // Write a function to find the longest common prefix string amongst an array of strings.
    // If there is no common prefix, return an empty string "".
    public String longestCommonPrefix(String[] strs) {
        try {
            if (strs.length > 200 || strs[0].length() > 200) {
                return "";
            }

            String s = strs[0];
            int min = strs[0].length();

            // find the smallest word
            for(int i = 1; i < strs.length; i++) {
                if (min > strs[i].length()) {
                    min = strs[i].length();
                    s = strs[i];
                }
            }

            // check if the letters of the smallest string are contained within all words
            StringBuilder prefix = new StringBuilder();
            boolean flag = true;
            for(int i = s.length(); i >= 0; i--) {
                s = s.substring(0, i);
                for(int j = 0; j < strs.length; j++) {
                    if(!strs[j].substring(0, i).contains(s)) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if(flag) {
                    prefix.append(s);
                    break;
                }
            }

            return prefix.toString();
        } catch(Exception e) {
            return "";
        }
    }

    // Valid Parentheses
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    public boolean isValid(String s) {
        boolean res = false;
        // check if string parameter (s) has valid characters
        if ( (s.contains("()") || s.contains("[]") || s.contains("{}")) && s.length() % 2 == 0 ) {
            // Declare and initialize stack
            Stack<String> stk = new Stack<>();
            // split the string parameter s
            String[] str = s.split("");

            // loop through split string and push elements into the stack
            // if closing parenthesis( ')', ']', '}' ) is found pop the stack
            for(int i = 0; i < str.length; i++) {
                if ( (str[i].equals(")") || str[i].equals("]") || str[i].equals("}")) && !stk.isEmpty()) {
                    // test to see if the top of the stack is the same type of parenthesis
                    boolean flag = false;
                    switch(str[i]) {
                        case ")": flag = stk.peek().equals("("); break;
                        case "]": flag = stk.peek().equals("["); break;
                        case "}": flag = stk.peek().equals("{"); break;

                    }
                    if (flag) {
                        stk.pop();
                    }
                    // continue to avoid pushing the closing parenthesis into the stack
                    continue;
                }
                stk.push(str[i]);
            }
            // if stack is empty set the result to true
            if(stk.isEmpty()) {
                res = true;
            }
        }
        return res;
    }

    // Remove Duplicates from Sorted Array
    // Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
    // Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    public int removeDuplicates(int[] nums) {
//        // Declare a hashset will use this to get rid of duplicates from the array nums
//        Set<Integer> set = new HashSet<>();
//
//        // loop through nums array and store each element into the hashset (autoboxing happens here)
//        for(int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        // loop through hashset to store the values into an ArrayList
//        Iterator it = set.iterator();
//        ArrayList<Integer> unique = new ArrayList<>();
//        while(it.hasNext()) {
//            unique.add(Integer.parseInt(it.next().toString()));
//        }
//        // sort the unique list of values
//        Collections.sort(unique);
//
//        // now store into the front of nums array
//        for(int i = 0; i < unique.size(); i++) {
//            nums[i] = unique.get(i);
//        }
//
//        return unique.size();

        // Improved solution
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];

            }
        }
        return i + 1;
    }

    // Implement strStr()
    // Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    // Clarification:
    // What should we return when needle is an empty string? This is a great question to ask during an interview.
    // For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Search in a Binary Search Tree
    // Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals
    // the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        TreeNode current = root;
        while(current != null) {
            // val is less than the current node value
            // traverse to the left side of the tree
            if(val < current.val && current.left != null) {
                current = current.left;
            }
            // val is greater than current node value
            // traverse to the right side of the tree
            else if (val > current.val && current.right != null) {
                current = current.right;
            }
            // if val is equal to the current node break the loop
            else if(val == current.val) {
                break;
            } else {
                return null;
            }
        }
        return current;
    }

    // Merge Sorted Array
    // Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    // Note:
    // The number of elements initialized in nums1 and nums2 are m and n respectively.
    // You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Declare ArrayList to store the elements of both nums1 and nums2
        ArrayList<Integer> al = new ArrayList<>();

        // Declare int j as an index to iterate through both nums1 and nums2
        int j = 0;

        // Add elements from both nums1 and nums2 into the ArrayList
        for(int i = 0; i < m+n; i++) {
            // Add element from nums1 into ArrayList if i is less than m
            if(i < m) {
                al.add(nums1[j]);
            }
            // set j back to 0 if i is exactly equal to m, then add the first element from nums2
            else if (i == m) {
                j = 0;
                al.add(nums2[j]);
            }
            // add elements from nums2 into ArrayList
            else {
                al.add(nums2[j]);
            }
            // increment j
            j++;
        }

        // sort ArrayList al
        Collections.sort(al);

        // assign j back to 0 (used as an iterator for nums1 in enhanced for loop)
        j = 0;
        // loop through ArrayList and re-assign the sorted list of integers to nums1
        for(int elem : al) {
            nums1[j++] = elem;
        }
    }

    // Merge Two Sorted Lists
    // Merge two sorted linked lists and return it as a new sorted list.
    // The new list should be made by splicing together the nodes of the first two lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // create a new head to store a reference to the new list
        ListNode head = new ListNode(-1);
        // declare reference to new head node which will help splice the two lists together
        ListNode splicer = head;

        // loop to traverse through and compare the node values of the two sorted linked lists
        while(l1 != null && l2 != null) {
            // check if list 1's node value is less than or equal to list 2's node value
            if(l1.val <= l2.val) {
                // if list 1's node value is less, then set splicer.next reference to list 1's node
                splicer.next = l1;
                // set list 1's node to reference the subsequent node
                l1 = l1.next;
            } else {
                // if list 2's node value is less, then set splicer.next reference to list 2's node
                splicer.next = l2;
                // set list 2's node to reference the subsequent node
                l2 = l2.next;
            }
            // set splicer to the new subsequent node
            splicer = splicer.next;
        }

        // check if either l1 or l2 is equal to null
        if(l1 != null) {
            splicer.next = l1;
        } else {
            splicer.next = l2;
        }

        // return the of the new list
        return head.next;
    }

    // Valid Palindrome
    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        // store lowercase string s after replacing all special characters and spaces
        String str = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        // append the modified s string into the StringBuilder to take advantage of reverse method
        sb.append(str);

        // return true or false if the strings are/are not equal
        return sb.reverse().toString().equals(str);
    }

    // Convert Sorted Array to Binary Search Tree
    // Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    // For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    public TreeNode sortedArrayToBST(int[] nums) {
        // check nums array
        if(nums == null || nums.length == 0) return null;

        // push all of the nums elements into ArrayList tree
        for(int elem : nums) {
            tree.add(elem);
        }

        // return the root node from the overloaded method sortedArrayToBST
        return buildTree(0, tree.size() - 1);
    }
    // the divide and conquer algorithm (method overload)
    public TreeNode buildTree(int low, int high) {

        // check conditions
        if(low > high || high < 0 || tree.isEmpty()) return null;
        if(low == high) return new TreeNode(tree.get(low));

        // find and set the mid value and set up the root node
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(tree.get(mid));

        // build left child
        TreeNode left = buildTree(low, mid-1);
        // build right child
        TreeNode right = buildTree(mid+1, high);
        root.left = left;
        root.right = right;
        return root;
    }

    // Write a function that reverses a string. The input string is given as an array of characters char[].
    // Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    // You may assume all the characters consist of printable ascii characters.
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;

        while(start < end) {
            // if start less than end swap characters
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }

    // Pascal's Triangle
    // Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    public List<List<Integer>> generate(int numRows) {
        // define the logic to generate pascal's triangle
        if(numRows == 0) return pascalsT;

        // add a new arraylist to pascal's triangle list
        pascalsT.add(new ArrayList<>());

        // set first row as 1
        pascalsT.get(0).add(1);

        for(int rowNum = 1; rowNum < numRows; rowNum++) {
            // Declare local list to build following rows
            List<Integer> row = new ArrayList<>();
            // Declare local list reference to reference previous row
            List<Integer> prevRow = pascalsT.get(rowNum - 1);

            // first row element will always be 1.
            row.add(1);

            // each element between the first and last is equal to the
            // sum of the elements above-and-to-the-left and above-and-to-the-right.
            for(int i = 1; i < rowNum; i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            // last row element will always be 1.
            row.add(1);

            // add the row to the triangle
            pascalsT.add(row);
        }
        // return pascal's triangle
        return pascalsT;
    }

    // First Unique Character in a String
    // Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
    public int firstUniqChar(String s) {
        // index local variable to store the index of the unique character
        int idx = -1;
        // Declare a hashmap to help solve this problem
        HashMap<Character, Integer> hmap = new HashMap<>();

        // build hashmap by storing each character along with a count of that character within the string
        for(int i = 0; i < s.length();i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // loop through the string again to check if the character count is equal to 1 (unique)
        for(int i = 0; i < s.length();i++) {
            // check if character is unique
            if (hmap.get(s.charAt(i)) == 1) {
                // assign index of the current character then break the loop
                idx = i;
                break;
            }
        }
        // return local idx variable
        return idx;
    }

    // Merge Intervals
    // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    // and return an array of the non-overlapping intervals that cover all the intervals in the input.
    public int[][] merge(int[][] intervals) {
        // check intervals length
        if(intervals.length == 0) return new int[0][0];

        // Declare ArrayList to store the combined intervals
        List<int[]> merge = new ArrayList<>();

        // sort the intervals before merging/combining overlapping intervals (using lambda expression to handle the comparator)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // store the start and end of the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // iterate through the intervals in the intervals array
        for(int i = 1; i < intervals.length; i++) {
            // write logic for each iteration
            // set currStart and currEnd to the interval currently being iterated through
            // declare current start and end variable for each interval within the array
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            // check if the current start is less than or equal to the end of the previous interval
            if(currStart <= end) {
                // don't update the start
                // update the end (use max method to find the higher value of first interval end and current interval end)
                end = Math.max(currEnd, end);
            } else {
                // add the merged interval to the list
                merge.add(new int[] {start, end});

                // update(reset to current) start and end
                start = currStart;
                end = currEnd;
            }
        }
        // need to add in the last interval to the list
        merge.add(new int[] {start, end});
        return merge.toArray(new int[merge.size()][]);
    }

    // Interval List Intersections
    public int[][] intervalIntersection(int[][] A, int[][] B) {

//        int[][] a = new int[][] { {0,2}, {5,10}, {13,23}, {24,25} };
//        int[][] b = new int[][] { {1,5}, {8,12}, {15,24}, {25,26} };

        // List to store the interval intersections
        List<int[]> intersections = new ArrayList<>();

        // set the start and end
        // set two int variables as pointers: one for A and one for B
        int a = 0;
        int b = 0;

        // iteration through the intervals --> while loop
        while(a < A.length && b < B.length) {
            int startA = A[a][0], endA = A[a][1];
//            System.out.println("startA: " + startA+ " endA: " + endA);
            int startB = B[b][0], endB = B[b][1];
//            System.out.println("startB: " + startB+ " endB: " + endB);

            // current values
            // maximum between both A and B start of intervals
            // minimum between both A and B end of intervals
            int start = Math.max(startA, startB);
            int end = Math.min(endA, endB);

            // compare current start with current end
            if(start <= end) {
                // add the intersection interval of A and B intervals to the list
                intersections.add(new int[] {start, end});
            }

            // increment either a or b to the next interval (if endA is less than endB move to )
            if(endA < endB) a++;
            else b++;
        }

        // return intersections
        return intersections.toArray(new int[intersections.size()][]);
    }

    // Pairs of Songs With Total Durations Divisible by 60
//    You are given a list of songs where the ith song has a duration of time[i] seconds.
//    Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
//    Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
    public int numPairsDivisibleBy60(int[] time) {

        /** Brute Force solution **/
        // accumulator
//        int pairs = 0;
//        for(int i = 0; i < time.length; i++) {
//            for(int j = i+1; j < time.length; j++) {
//                if( (time[i] + time[j]) % 60 == 0) {
//                    pairs++;
//                }
//            }
//        }
//        return pairs;

        /** Improved Solution **/
        // accumulator
        int pairs = 0;

        // Use hashmap to help solve this solution
//        Map<Integer, Integer> hmap = new HashMap<>();
        int[] map = new int[60];
        for(int t : time) {
            // if time modulus 60 is 0, then get the current value from the map (if null a 0 is added to pairs)
            if(t % 60 == 0) {
//                pairs += hmap.getOrDefault(0,0);
                pairs += map[0];
            } else { // if time modulus 60 is not equal to 0, then get the current value from map by subtracting
                    // time modulus 60 from 60 and add value to pairs
//                pairs += hmap.getOrDefault(60 - t % 60, 0);
                pairs += map[60 - t % 60];
            }
//            hmap.put(t % 60, hmap.getOrDefault(t % 60, 0) + 1);
            map[t % 60]++;
        }
        return pairs;
    }

    // Count and Say

    // The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
    // countAndSay(1) = "1"
    // countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a
    // different digit string. To determine how you "say" a digit string, split it into the minimal number of groups so
    // that each group is a contiguous section all of the same character. Then for each group, say the number of
    // characters, then say the character. To convert the saying into a digit string, replace the counts with a number
    // and concatenate every saying.
    public String countAndSay(int n) {
        if(n < 0) return "";

        String s = "1";
        while(n > 1) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < s.length(); ++i) {
                int count = 1;
                while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    ++count;
                    ++i;
                }
                result.append(count).append(s.charAt(i));
            }
            s = result.toString();
            --n;
        }
        return s;
    }

    // 3Sum
    // Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.
    // Notice that the solution set must not contain duplicate triplets.
    public List<List<Integer>> threeSum(int[] nums) {
        // List of Lists to store each unique triplets in the array that gives the sum of zero
        List<List<Integer>> list = new LinkedList();

        // Sort the nums array
        Arrays.sort(nums);

        // Iterate through array of nums
        for(int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1]) ) {
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - nums[i];

                while(low < high) {
                    // if a set of triplets are found and to the list
                    if(nums[low] + nums[high] == sum) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return list;
    }

    // Plus One
    // Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
    // The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
    // You may assume the integer does not contain any leading zero, except the number 0 itself.
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[n+1];
        newNum[0] = 1;
        return newNum;
    }

    // Missing Number
    // Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
    // Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
    public int missingNumber(int[] nums) {

        /** My First Solution */
//        // store the length of the nums array
//        int n = nums.length;
//        int missingNumber = nums[0];
//
//        // use a hashset to store all the values of nums
//        Set<Integer> set = new HashSet<>();
//        for(Integer elem:nums) {
//            set.add(elem);
//        }
//
//        // iterate to find the value that is missing
//        for(int i = 0; i <= n; i++) {
//            if (!set.contains(i)) {
//                missingNumber = i;
//                break;
//            }
//        }
//        return missingNumber;

        /** Cyclic Sort solution (can be used to solve a few other problems) */
        // store the length of nums array
        int n = nums.length;
        int i = 0;
        while(i < n) {
            // check if current element is not equal to its index position and is less than nums length
            if(nums[i] != i && nums[i] < n) {
                // store the current element value (index position in array where it should be)
                int j = nums[i];
                // swap current element value with whatever element value is at position j
                swap(nums, i, j);
            } else {
                // pre-increment i if current element value is equal to the index position
                 ++i;
            }
        }
        // check array to find the missing value
        for(int j = 0; j < n; j++){
            if(nums[j] != j){
                return j;
            }
        }
        // if for loop completes return the nums array length
        return n;

        /** Improved Solution */
//        int n = nums.length;
//        // store the series equation (closed formula) or the formula for sum of consecutive numbers
//        // use this to help find the missing number
//        int totalSum = n * (n + 1) / 2;
//        // accumulator to store the sum of the nums array
//        int actualSum = 0;
//
//        // iterate through nums array and calculate the sum
//        for(int i = 0; i < n; i++) {
//            // calculate the sum of nums array
//            actualSum += nums[i];
//        }
//
//        // check if formula result is not equal to the sum of nums (if they are equal return 0)
//        if(totalSum != actualSum) {
//            // return the difference between the formula result and sum of nums (the missing number)
//            return Math.abs(totalSum - actualSum);
//        } else {
//            return 0;
//        }
    }

    // swap function to swap two element values within an array
    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // Sqrt(x)
    // Given a non-negative integer x, compute and return the square root of x.
    // Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
    public int mySqrt(int x) {
        /** Math class square root method */
        // return (int) Math.sqrt((double) x);

        /** Binary Search Solution */
        int low = 1;
        int high = x;

        while(low <= high) {
            // calculate the mid value
            long mid = low + (high - low) / 2;
//            System.out.println(mid);

            // check if mid is the square root
            if(mid * mid == x) {
                return (int) mid;
            } else if(mid * mid > x) {
                // if mid squared is greater set high equal to mid value minus 1
                high = (int) mid-1;
            } else {
                // if mid squared is less than set low equal to mid value plus 1
                low = (int) mid+1;
            }
        }
        return high;
    }

    // Maximum Subarray
    // Given an integer array nums, find the contiguous subarray (containing at least one number) which has
    // the largest sum and return its sum.
    // Follow up: If you have figured out the O(n) solution, try coding another solution using the divide
    // and conquer approach, which is more subtle.
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return -1;

        // Declare maxSum to store the maximum subarray sum
        int maxSum = nums[0];
        // Declare currentSum to help store the current maximum contiguous subarray sum
        // throughout the iteration process
        int currentSum = maxSum;

        // iterate through nums array and determine the max contiguous subarray sum
        for(int i = 1; i < nums.length; i++) {
            // calculate the current max sum between the most recent contiguous subarray max and current element value
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            // check if the currentSum is greater than maxSum (most recently calculated max)
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    // Maximum Product Subarray
    // Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
    // which has the largest product.
    public int maxProduct(int[] nums) {

        // handle edge case if nums parameter is empty
        if(nums.length == 0) return -1;

        // Declare three variables
        // currentMax to help keep track of the max product
        int currentMax = nums[0];
        // currentMin to help keep track of the product of negative values
        int currentMin = nums[0];
        // maxProduct to store the highest contiguous product
        int maxProduct = nums[0];

        for(int i = 1; i < nums.length; i++) {
            // Assign a temp variable to the currentMax to be used for minimum calculation
            int temp = currentMax;

            // Set the current max product between currentMax * current element, currentMin * current element
            // or current element (will continue contiguous subarray or begin a new subarray)
            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);

            // assign the most minimum product to help account for the product of negative numbers with currentMax
            currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);

            // Set the maxProduct to the maximum contiguous subarray value
            if(currentMax > maxProduct) {
                maxProduct = currentMax;
            }
        }

        return maxProduct;
    }

    // Binary Tree Inorder Traversal
    // Given the root of a binary tree, return the inorder traversal of its nodes' values.
    public List<Integer> inorderTraversal(TreeNode root) {

        // Stack to help perform the inorder traversal
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        TreeNode currentNode = root;
        while(currentNode != null || !stk.isEmpty()) {
            // left traversal
            while(currentNode != null) {
                // add currentNode to the stack (root node)
                stk.push(currentNode);
                currentNode = currentNode.left;
            }

            // pop the stack and add to the current node value to the result list (root node if left is null)
            currentNode = stk.pop();
            result.add(currentNode.val);

            // then right traversal
            currentNode = currentNode.right;
        }
        return result;
    }

    // Symmetric Tree
    // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    public boolean isSymmetric(TreeNode root) {
        /** Iterative Solution */
//        // Declare a queue to store the mirrored nodes
//        Queue<TreeNode> q = new LinkedList<>();
//        // add the root node twice initially
//        q.add(root);
//        q.add(root);
//
//        // loop through the tree to check for symmetry
//        while(!q.isEmpty()) {
//            // declare local TreeNode objects (pointers) to reference the nodes from the queue
//            TreeNode t1 = q.poll();
//            TreeNode t2 = q.poll();
//
//            // check if the tree1 node and tree2 node are null
//            if(t1 == null && t2 == null) continue;
//            // check if either t1 or t2 is null
//            if(t1 == null || t2 == null) return false;
//            // if two node values are equal
//            if(t1.val != t2.val) return false;
//
//            // add left subtree's left node and right subtree's right node into the queue
//            q.add(t1.left);
//            q.add(t2.right)
//            // add left subtree's right node and right subtree's left node into the queue
//            q.add(t1.right);
//            q.add(t2.left);
//        }
//        return true;

        /** Recursive Solution */
        return testSymmetry(root, root);
    }

    public boolean testSymmetry(TreeNode t1, TreeNode t2) {
        // check if the tree1 node and tree2 node are null
        if(t1 == null && t2 == null) return true;
        // check if either t1 or t2 is null
        if(t1 == null || t2 == null) return false;
        // if the node values are equal
        // test if the left subtree's left node(s) and right subtree's right node(s) mirror each other
        // then check if the left subtree's (each of it's subtrees) right node(s)
        // and the right subtree's (each of it's subtrees) left node(s) mirror each other
        return (t1.val == t2.val)
                && testSymmetry(t1.left, t2.right)
                && testSymmetry(t1.right, t2.left);

    }

    // Best Time to Buy and Sell Stock II
    // Say you have an array prices for which the ith element is the price of a given stock on day i.
    // Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
    // Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
    public int maxProfit(int[] prices) {
        // declare variable to accumulate max profit
        int maxProfit = 0;

        // loop through prices array
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    // Gas Station
    // There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    // You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
    // You begin the journey with an empty tank at one of the gas stations.
    // Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit
    // once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /** Brute Force Solution */
        // Loop through the gas array
//        for(int s = 0; s < gas.length; s++) {
//            // int variable to help keep track of the remaining gas in the car
//            int tank = 0;
//            // boolean to help with keeping track of the starting point (s) if circuit completes
//            boolean isPossible = true;
//
//            // nested loop to traverse to each gas station to complete a circuit
//            for(int i = s; i < gas.length + s; i++) {
//                // must use modulus to ensure that if the starting point is not the first gas station
//                // the iteration will not go out of bounds and the gas amount and cost amount are properly accessed
//                int station = i % gas.length;
//
//                // calculate the amount in tank by subtracting the gas from the cost
//                tank += gas[station] - cost[station];
//
//                // if tank is less than zero set isPossible to false and break nested loop
//                if(tank < 0) {
//                    isPossible = false;
//                    break;
//                }
//            }
//            // check isPossible (if circuit was completed)
//            if(isPossible) {
//                return s;
//            }
//        }
//
//        return -1;

        /** Improved Solution (One Pass) */
        // determine if the circuit is possible by calculating the difference (total gas - total cost)
        int diff = 0;
        for(int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
        }
        if(diff < 0) return -1;

        // declare variable for tank of car and startPoint (store starting gas station)
        int tank = 0;
        int startPoint = 0;

        // loop through gas array to find the startPoint point where circuit will complete
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                startPoint = i + 1;
                // reset tank back to zero (new startPoint point)
                tank = 0;
            }
        }
        return startPoint;
    }
}
