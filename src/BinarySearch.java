import java.util.ArrayList;

public class BinarySearch {

    // Search in a Binary Search Tree
    // Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals
    // the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
    public static TreeNode searchBST(TreeNode root, int val) {
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

    // Convert Sorted Array to Binary Search Tree
    // Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    // For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    public static TreeNode sortedArrayToBST(int[] nums) {

        final ArrayList<Integer> tree= new ArrayList<>();

        // check nums array
        if(nums == null || nums.length == 0) return null;

        // push all of the nums elements into ArrayList tree
        for(int elem : nums) {
            tree.add(elem);
        }

        // return the root node from the overloaded method sortedArrayToBST
        return buildTree(tree,0, tree.size() - 1);
    }
    // the divide and conquer algorithm (method overload)
    public static TreeNode buildTree(ArrayList<Integer> tree, int low, int high) {

        // check conditions
        if(low > high || high < 0 || tree.isEmpty()) return null;
        if(low == high) return new TreeNode(tree.get(low));

        // find and set the mid value and set up the root node
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(tree.get(mid));

        // build left child
        TreeNode left = buildTree(tree, low, mid-1);
        // build right child
        TreeNode right = buildTree(tree, mid+1, high);
        root.left = left;
        root.right = right;
        return root;
    }
}
