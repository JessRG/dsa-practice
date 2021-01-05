import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        LeetcodeList lcList = new LeetcodeList();

        /** selectionSort Test **/
        int[] nums = new int[] {5,2,3,1};
//        System.out.println(Arrays.toString(lcList.sortArray(nums)));

        /** bubbleSort Test **/
//        lcList.bubbleSort(new int[] {9,5,7,3,6,2,1});

        /** MergeSort Test **/
//        nums = new int[] {4,9,7,6,5,3,1};
//        System.out.println(Arrays.toString(lcList.mergeSort(nums)));

        /** Binary Search Test **/
//        nums = new int[] {1,3,4,5,7,9,13,15,16,17,19};
//        System.out.println(lcList.binarySearch(17, nums, 0, nums.length));

        /** Test of Two Sum **/
//        System.out.println(Arrays.toString(lcList.twoSum(new int[] {2,7,11,15}, 9)));
//        System.out.println(Arrays.toString(lcList.twoSum(new int[] {3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(lcList.twoSum(new int[] {3, 3}, 6)));
        /** End Test of Two Sum **/

        /** Test of Longest Common Prefix **/
//        System.out.println(lcList.longestCommonPrefix(new String[] { "flower","flow","flight" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "dog","racecar","car" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "hello","hell","helenor" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "a" }));
//        System.out.println(lcList.longestCommonPrefix(new String[] { "reflower", "flow", "flight" }));
        /** End Test of Longest Common Prefix **/

        /** Test of Valid Parentheses **/
//        System.out.println(lcList.isValid("()"));
//        System.out.println(lcList.isValid("()[]{}"));
//        System.out.println(lcList.isValid("(]"));
//        System.out.println(lcList.isValid("([)]"));
//        System.out.println(lcList.isValid("{[]}"));
//        System.out.println(lcList.isValid("(){[]}"));
//        System.out.println(lcList.isValid("{[]}()"));
//        System.out.println(lcList.isValid("(}{[]}[}"));
//        System.out.println(lcList.isValid("[](])"));
        /** End Test of Valid Parentheses **/

        /** Test of Remove Duplicates from Sorted Array **/
//        int[] arr = new int[] { 1,1,2 };
//        arr = new int[] { 0,0,1,1,1,2,2,3,3,4 };
//        arr = new int[] { -3,-1,0,0,0,3,3 };
//        int len = lcList.removeDuplicates(arr);
//        System.out.print(len + ", [");
//        for(int i = 0; i < len; i++) {
//            if (i == len - 1) {
//                System.out.println(arr[i] + "]");
//            } else {
//                System.out.print(arr[i] + ",");
//            }
//        }
        /** End Test of Remove Duplicates from Sorted Array **/

        /** Test of Implement strStr() **/
//        System.out.println(lcList.strStr("hello", "ll"));
//        System.out.println(lcList.strStr("aaaaa", "bba"));
//        System.out.println(lcList.strStr("", ""));
        /** End Test of Implement strStr() **/

        /** Test of Search in a Binary Search Tree **/
//        TreeNode tree = new TreeNode(4, new TreeNode(2), new TreeNode(7));
//        tree.left.left = new TreeNode(1);
//        tree.left.right = new TreeNode(3);
////        TreeNode sTree = lcList.searchBST(tree, 2);
//
//        tree = new TreeNode(1, null, new TreeNode(2));
//        tree.right.left = new TreeNode(3);
////        TreeNode sTree = lcList.searchBST(tree, 2);
//
//        tree = new TreeNode(5, new TreeNode(4), new TreeNode(7));
//        tree.left.left = new TreeNode(3);
//        tree.left.left.left = new TreeNode(-1);
//        tree.right.left = new TreeNode(2);
//        tree.right.left.left = new TreeNode(9);
//        TreeNode sTree = lcList.searchBST(tree, 8);
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//
//        if (sTree != null) {
//            Queue<TreeNode> lvlOrderTree = TreeNode.traverseTree(sTree);
//            Iterator it = lvlOrderTree.iterator();
//            int i = 0;
//            while(it.hasNext()) {
//                i++;
//                sb.append( String.format("%d%s", ((TreeNode) it.next()).val, i == lvlOrderTree.size() ? "]" : ",") );
//            }
//        } else{
//            sb.append("]");
//        }
//        System.out.println(sb);
        /** End Test of Search in a Binary Search Tree **/

        /** Test of Merge Sorted Array **/
//        int[] nums1 = new int[] {1,2,3,0,0,0};
//        lcList.merge(nums1, 3, new int[] {2,5,6}, 3);
//        lcList.merge(nums1, 3, new int[] {}, 0);
//        nums1 = new int[] {0};
//        lcList.merge(nums1, 0, new int[] {}, 0);
//        nums1 = new int[] {2,0};
//        lcList.merge(nums1, 1, new int[] {1}, 1);
//        System.out.print("[");
//        for(int i = 0; i < nums1.length; i++) {
//            System.out.print(String.format("%d%s", nums1[i], i == nums1.length - 1 ? "]" : ","));
//        }
        /** End Test of Merge Sorted Array **/

        /** Test of Merge Two Sorted Lists **/
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)) );
//        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)) );
//        ListNode.traverseList(lcList.mergeTwoLists(l1, l2));
        /** End Test of Merge Two Sorted Lists **/

        /** Test of Convert Sorted Array to Binary Search Tree **/
//        int[] nums = new int[] {-10, -3, 0, 5, 9};
//        TreeNode.displayTree(lcList.sortedArrayToBST(nums));
        /** End Test of Convert Sorted Array to Binary Search Tree **/

        /** Test of Valid Palindrome **/
//        String s = "A man, a plan, a canal: Panama";
//        s = "race a car";
////        s = "0P";
//        System.out.println(lcList.isPalindrome(s));
        /** End Test of Valid Palindrome **/

        /** Test of First Unique Character in a String **/
//        String s = "leetcode";
////        s = "loveleetcode";
////        s = "cc";
////        s = "z";
//        System.out.println(lcList.firstUniqChar(s));
        /** End Test of First Unique Character in a String **/

        /** Test of Reverse String **/
        char[] input = new char[] {'h','e','l','l','o'};
        input = new char[] {'H','a','n','n','a', 'h'};
//        lcList.reverseString(input);
        /** End Test of Reverse String **/

        /** Test of Merge Intervals **/
//        int[][] intervals = new int[][] { {1,3}, {2,6}, {8,10}, {15,18} };
//        int[][] result = lcList.merge(intervals);
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("[ ");
//        for(int i = 0; i < result.length; i++) {
//            sb.append(String.format("%s%s", Arrays.toString(result[i]), i == result.length-1 ? " ]" : ","));
//        }
//        System.out.println(sb.toString());
        /** End Test of Merge Intervals **/

        /** Test of Interval List Intersections **/
//        int[][] a = new int[][] { {0,2}, {5,10}, {13,23}, {24,25} };
//        int[][] b = new int[][] { {1,5}, {8,12}, {15,24}, {25,26} };
//        int[][] intersections = lcList.intervalIntersection(a, b);
//
//        StringBuilder list = new StringBuilder();
//        list.append("[ ");
//        for(int i = 0; i < intersections.length; i++) {
//            list.append(String.format("%s%s", Arrays.toString(intersections[i]), i == intersections.length-1 ? " ]" : ","));
//        }
//        System.out.println(list.toString());
        /** End Test of Interval List Intersections **/

        /** Test of Pairs of Songs With Total Durations Divisible by 60 **/
//        int[] t = new int[] { 30, 20, 150, 100, 40 };
//        System.out.println(lcList.numPairsDivisibleBy60(t));
        /** End Test of Pairs of Songs With Total Durations Divisible by 60 **/

        /** Test of Count and Say **/
//        System.out.println(lcList.countAndSay(4));
        /** End Test of Count and Say **/

        /** Test of 3Sum **/
//        nums = new int[] { -1,0,1,2,-1,-4 };
//        List<List<Integer>> ls = lcList.threeSum(nums);
//        System.out.println(Arrays.asList(ls));
        /** End Test of 3Sum **/

        /** Test of Plus One **/
//        int[] digits = new int[] { 1,2,3 };
////        int[] result = lcList.plusOne(digits);
//
//        for(int e : lcList.plusOne(digits)) {
//            System.out.print(e + " ");
//        }
        /** End Test of Plus One **/

        /** Test of Maximum Subarray **/
        nums = new int[] { 3,2,1 };
        nums = new int[] { 0,1 };
        nums = new int[] { 9,6,4,2,3,5,7,0,1 };
        int res = lcList.missingNumber(nums);
        System.out.println(res);
        /** End Test of Maximum Subarray **/

        /** Test of Maximum Subarray **/
//        nums = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
//        int res = lcList.maxSubArray(nums);
//        System.out.println(res);
        /** End Test of Maximum Subarray **/

        /** Test of Maximum Product Subarray **/
//        nums = new int[] { 2,3,-2,4 };
//        int res = lcList.maxProduct(nums);
//        System.out.println(res);
        /** End Test of Maximum Product Subarray **/
    }
}
