import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LeetcodeList {

    // Declaring ArrayList object to help solve some problems
    private final ArrayList<Integer> tree;
    private final List<List<Integer>> pascalT;
    private final Scanner scan;

    LeetcodeList() {
        this.tree = new ArrayList<>();
        this.pascalT = new ArrayList<>();
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

    // 3Sum
    // Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.
    // Notice that the solution set must not contain duplicate triplets.
//    public List<List<Integer>> threeSum(int[] nums) {
//
//    }


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

    // Pascal's Triangle
    // Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    public List<List<Integer>> generate(int numRows) {
        // define the logic to generate pascal's triangle
        return pascalT;
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

    // Interval List Intersections
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        // write logic for the interval intersection problem here...
        return res.toArray(new int[res.size()][]);
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

    // Two Strings
    // Given two arrays of strings, determine whether corresponding elements contain a common substring.
    // For each test, print the result on a new line, either YES if there is a common substring, or NO.
    public void commonSubstring(List<String> a, List<String> b) {
        // Write your code here
        for(int i = 0; i < a.size(); i++) {
            String strA = a.get(i);
//            System.out.println(strA);
            // create a hashmap to store the characters of the string(s) of list a
            HashMap<Character, Integer> hmap = new HashMap<>();
            for(int j = 0; j < strA.length(); j++) {
                hmap.put(strA.charAt(j), hmap.get(strA.charAt(j)) == null ? 1 : hmap.get(strA.charAt(j)) + 1 );
                // System.out.println(hmap.get(strA.charAt(j)) + 1);
            }
            String strB = b.get(i);
//            System.out.println(strB);
            boolean flag = false;
            for(int j = 0; j < strB.length(); j++) {
                if(hmap.containsKey(strB.charAt(j))) {
                    // System.out.println(strB.charAt(j));
                    flag = true;
                }
            }
            System.out.println(flag ? "YES" : "NO");
            flag = false;
        }
    }

    // Large Responses
    // You are given a log file with a list of GET requests delimited with double quotes and spaces.
    // A sample and the structure of the text file containing the log entries are given below.
    // Given a filename that denotes a text file in the current working directory. Create an output file with the name
    // "bytes_" prefixed to the filename (bytes_filename) which stores the information about large responses.

    // Write the following to the output file:
    // 1. The first line must contain the number of requests that have more than 5000 bytes sent in their response.
    // 2. The second line must contain the total sum of bytes sent by all responses sending more than 5000 bytes.
    public void findLargeResponses() throws IOException {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line;

        // read lines from the file and append to the StringBuilder
        while( (line = br.readLine()) != null ) {
            sb.append(line + "\n");
        }
        // close BufferedReader
        if (br != null) {
            br.close();
        }

        // split the built StringBuilder
        String [] split = sb.toString().replaceAll("([^\\d\\n][\\w.:/]*.)", "").split("\n");
        int count = 0;
        long bytes = 0;
        for(String elem : split) {
            long val = Long.parseLong(elem);
            if(val > 5000L) {
                count++;
                bytes += val;
            }
        }
//        System.out.printf("count: %d\nbytes: %d\n", count, bytes);

        // Declare File object for the new output file
        File file = new File("bytes_" + filename);

        // This logic makes sure that the file gets created if it is not present
        if (!file.exists()) {
            file.createNewFile();
        }
        // Create BufferedWriter to write to the new output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(String.format("%d\n%d", count, bytes));
        System.out.println("File written successfully!");

        // close BufferedWriter
        if(bw != null) {
            bw.close();
        }
    }

    // Shopper's Delight
    // A shopaholic has to buy a pair of jeans, a pair of shoes, a skirt, and a top with budgeted dollars.
    // Given the quantity of each product and the price per unit, determine how many options there are to buy all
    // items, If required, all budgeted dollars can be spent.
    // Example:
    // priceOfJeans = [2, 3]
    // priceOfShoes = [4]
    // priceOfSkirts = [2,3]
    // priceOfTops = [1.2]
    // budget = 10
    // The shopper must buy shoes for 4 dollars since there is only one option. This leaves 6 dollars to spend on the
    // other 3 items. Combinations of prices paid for jeans, skirts, and tops respectively that add up to 6 dollars
    // or less are [2,2,2],[2,2,1], [3,2,1], [2,3,1]
    public int getNumberOfOptions(int[] priceOfJeans, int[] priceOfShoes, int [] priceOfSkirts, int[] priceOfTops, int budget) {
        int opt = 0;
        // Write logic here...
        return opt;
    }
}
