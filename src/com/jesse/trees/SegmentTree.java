package com.jesse.trees;

public class SegmentTree {
    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        // construct left tree and right tree
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    // query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    public int query(Node node, int qsi, int qei) {
        // node completely inside query interval
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // completely outside
            return 0;
        } else {
            // overlapping
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        StringBuilder str = new StringBuilder();

        if (node.left != null) {
            str = str.append("Intervalk=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ");
        } else {
            str = str.append("No left child");
        }

        // for current node
        str = str.append("Intervalk=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " => ");

        if (node.right != null) {
            str = str.append("Intervalk=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data);
        } else {
            str = str.append("No right child");
        }

        System.out.println(str +"\n");

        // call recursion
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }
}
