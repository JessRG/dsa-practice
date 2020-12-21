import java.util.*;

public class Test {
    public static void main(String[] args) {
        LeetcodeList lcList = new LeetcodeList();

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
        int[] nums1 = new int[] {1,2,3,0,0,0};
        lcList.merge(nums1, 3, new int[] {2,5,6}, 3);
        lcList.merge(nums1, 3, new int[] {}, 0);
        nums1 = new int[] {0};
        lcList.merge(nums1, 0, new int[] {}, 0);
        nums1 = new int[] {2,0};
        lcList.merge(nums1, 1, new int[] {1}, 1);
        System.out.print("[");
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(String.format("%d%s", nums1[i], i == nums1.length - 1 ? "]" : ","));
        }
        /** End Test of Merge Sorted Array **/
    }
}
