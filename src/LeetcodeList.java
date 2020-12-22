import java.util.*;

public class LeetcodeList {


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

    // Convert Sorted Array to Binary Search Tree
    // Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    // For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    public TreeNode sortedArrayToBST(int[] nums) {
        // check nums array
        if(nums != null || nums.length == 0) return null;

        // return the root node from the overloaded method sortedArrayToBST
        return sortedArrayToBST(0, nums.length - 1, nums);
    }
    // the divide and conquer algorithm (method overload)
    public TreeNode sortedArrayToBST(int low, int high, int[] nums) {
        // need write the logic out for this method
        TreeNode root = new TreeNode();
        return root;
    }
}
