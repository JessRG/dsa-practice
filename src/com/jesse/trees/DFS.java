package com.jesse.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        // [5,3,6,2,4,null,null,1]
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
//        System.out.println(kthSmallest(root, 3));

        DFS depth = new DFS();
        depth.dfsStack(root);
    }

    // DFS using Stack
    void dfsStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        stk.push(node);

        while(!stk.isEmpty()) {
            TreeNode current = stk.pop();
            System.out.print(current.val + " ");

            if (current.right != null) {
                stk.push(current.right);
            }
            if (current.left != null) {
                stk.push(current.left);
            }
        }
        System.out.println();
    }

    // Diameter of Binary Tree
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Invert a Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    // Maximum Depth of a Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST(0, nums.length, nums);
    }

    private TreeNode sortedArrayToBST(int start, int end, int[] nums) {
        // binary search (recursive)
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        TreeNode left = sortedArrayToBST(start, mid, nums);
        TreeNode right = sortedArrayToBST(mid + 1, end, nums);
        root.left = left;
        root.right = right;

        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current.left != null) {
            TreeNode rightMost = current.left;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = root.right;
            current.right = current.left;
            current.left = null;
            current = current.right;
        }
    }

    // Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if (low != null && node.val <= low) {
            return false;
        }

        if (high != null && node.val >= high) {
            return false;
        }

        boolean leftTree = isValidBST(node.left, low, node.val);
        boolean rightTree = isValidBST(node.right, node.val, high);

        return leftTree && rightTree;
    }

    // Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    // Kth Smallest Element in a BST
//    static ArrayList<Integer> inOrder = new ArrayList<>();
//    public static int kthSmallest(TreeNode root, int k) {
//        kthSmallest(root);
//        return inOrder.get(k-1);
//    }
//
//    private static int kthSmallest(TreeNode root) {
//        if (root == null) {
//            return -1;
//        }
//
//        kthSmallest(root.left);
//        inOrder.add(root.val);
//        kthSmallest(root.right);
//
//        return root.val;
//    }

        // Space Efficient Solution
    static int count = 0;
    public static int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k).val;
    }

    public static TreeNode inOrder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = inOrder(root.left, k);
        if (left != null) {
            return left;
        }

        count++;

        if (count == k) {
            return root;
        }

        return inOrder(root.right, k);
    }

    // Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int r = preorder[0];
        int index = 0;

        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }

    // Leaf-Similar Trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> leftT = leaves(root1);
        List<Integer> rightT = leaves(root2);
        return Arrays.deepEquals(leftT.toArray(), rightT.toArray());
    }

    private List<Integer> leaves(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            return list;
        }

        List<Integer> left = leaves(node.left);
        List<Integer> right = leaves(node.right);
        left.addAll(right);
        return left;
    }

    private List<Integer> leavesIterative(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stk = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stk.push(node);
        while(!stk.isEmpty()) {
            TreeNode n = stk.pop();

            if (n.left != null) {
                stk.push(n.left);
            }
            if (n.right != null) {
                stk.push(n.right);
            }
            if (n.left == null && n.right == null) {
                res.add(n.val);
            }
        }
        return res;
    }
}
