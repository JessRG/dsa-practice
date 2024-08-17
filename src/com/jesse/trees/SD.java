package com.jesse.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SD {
    // Serialize and Deserialize Binary Tree
    public List<String> serialize(TreeNode node) {
        List<String> list = new ArrayList<>();
        dehydrate(node, list);
        return list;
    }

    void dehydrate(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));

        dehydrate(node.left, list);
        dehydrate(node.right, list);
    }

    TreeNode deserialize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = rehydrate(list);
        return node;
    }

    TreeNode rehydrate(List<String> list) {
        String value = list.remove(list.size() - 1);

        if (value.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = rehydrate(list);
        node.right = rehydrate(list);

        return node;
    }
}
