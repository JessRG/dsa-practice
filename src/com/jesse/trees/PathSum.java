package com.jesse.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PathSum {

    // Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Preorder Traversal
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // Sum Root to Leaf Numbers
    public int sumNumbers(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return sumRootToLeaf(node.left, sum) + sumRootToLeaf(node.right, sum);
    }

    // Binary Tree Maximum Path
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }

    private int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxPath(node.left);
        int right = maxPath(node.right);

        // Ignore negative path from left or right
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = node.val + left + right;
        ans = Math.max(ans, pathSum);

        return Math.max(left, right) + node.val;
    }

    // Path Exists in Binary Tree from Root to Leaf
    boolean findPath(TreeNode node, int[] arr) {
        if (node == null) {
            return arr.length == 0;
        }

        return isPath(node, arr, 0);
    }

    private boolean isPath(TreeNode node, int[] arr, int lvl) {
        if (node == null) {
            return false;
        }

        if (lvl >= arr.length || node.val != arr[lvl]) {
            return false;
        }

        if (node.left == null && node.right == null && lvl == arr.length - 1) {
            return true;
        }

        return isPath(node.left, arr, lvl + 1) || isPath(node.right, arr, lvl + 1);
    }

    // Path Exists in Binary Tree at Any Nodes
    public int countPaths(TreeNode node, int sum) {
        List<Integer> path = new ArrayList<>();
        return findPaths(node, sum, path);
    }

    private int findPaths(TreeNode node, int sum, List<Integer> path) {
        if (node == null) {
            return 0;
        }

        path.add(node.val);
        int count = 0;
        int s = 0;

        // calculate how many path that can be made
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasNext()) {
            s += itr.previous();

            if (s == sum) {
                count++;
            }
        }

        count += findPaths(node.left, s, path) + findPaths(node.right, s, path);

        // backtrack
        path.remove(path.size() - 1);

        return count;
    }

    // store paths in list
    public List<List<Integer>> listPaths(TreeNode node, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathsList(node, sum, path, paths);
        return paths;
    }

    private void findPathsList(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.val == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            findPathsList(node.left, sum - node.val, path, paths);
            findPathsList(node.right, sum - node.val, path, paths);
        }

        // backtrack
        path.remove(path.size() - 1);
    }
}
