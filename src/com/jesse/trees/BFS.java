package com.jesse.trees;

import java.util.*;

public class BFS {
    // Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            int lvlSize = q.size();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode current = q.poll();
                lvl.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            levels.add(lvl);
        }

        return levels;
    }

    // Average of Levels in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size();
            double avgLvl = 0;

            for (int i = 0; i < lvlSize; i++) {
                TreeNode current = q.poll();
                avgLvl += current.val;

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            avgLvl = avgLvl / lvlSize;
            levels.add(avgLvl);
        }

        return levels;
    }

    // Level Order Successor of a Node
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode current = q.poll();

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }

                if (current.val == key) {
                    break;
                }
            }
        }

        return q.peek();
    }

    // Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerFirst(root);
        boolean reverse = false;

        while (!dq.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            int lvlSize = dq.size();

            for (int i = 0; i < lvlSize; i++) {
                if (reverse) {
                    TreeNode current = dq.pollLast();

                    lvl.add(current.val);

                    if (current.right != null) {
                        dq.offerFirst(current.right);
                    }
                    if (current.left != null) {
                        dq.offerFirst(current.left);
                    }
                } else {
                    TreeNode current = dq.pollFirst();

                    lvl.add(current.val);

                    if (current.left != null) {
                        dq.offerLast(current.left);
                    }

                    if (current.right != null) {
                        dq.offerLast(current.right);
                    }
                }
            }
            levels.add(lvl);
            reverse = !reverse;
        }

        return levels;
    }

    // Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            int lvlSize = q.size();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode current = q.poll();
                lvl.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            levels.add(0, lvl);
        }

        return levels;
    }

    // Populating Next Right Pointers in Each Node
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }

    public Node connectRec(Node root) {
        if (root == null) {
            return null;
        } else {
            if (root.left != null) {
                root.left.next = root.right;
            }

            if (root.right != null && root.next != null) {
                root.right.next = root.next.left;
            }

            connectRec(root.left);
            connectRec(root.right);
            return root;
        }
    }

    // Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            int lvlSize = q.size();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode current = q.poll();
                lvl.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            ans.add(lvl.get(lvlSize - 1));
        }

        return ans;
    }

    // Cousins in Binary Tree
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
            (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }

        // check left side
        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        // check right side
        return findNode(node.right, x);
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return node.left == x && node.right == y || node.left == y && node.right == x
                || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }

    private int level(TreeNode node, TreeNode x, int lvl) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return lvl;
        }

        int l = level(node.left, x, lvl+1);
        if (l != 0) {
            return l;
        }

        return level(node.right, x, lvl+1);
    }

    // Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
