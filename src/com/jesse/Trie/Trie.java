package com.jesse.Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Function to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true; // Mark the end of the word
    }

    // Function to search a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                return false; // Word not found
            node = node.children[index];
        }
        return node.isEnd; // Return true if word exists, false otherwise
    }

    // Function to provide search suggested words
    public List<String> suggestionSearch(String prefix) {
        TrieNode node = root;

        List<String> list = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return list;
            }
            node = node.children[c - 'a'];
        }

        dfs(node, new StringBuilder(prefix), list);

        return list;
    }

    // Recursive function to help search for suggested words in Trie
    private void dfs(TrieNode node, StringBuilder word, List<String> list) {
        if (list.size() == 3) {
            return;
        }
        if (node.isEnd) {
            list.add(word.toString());
        }

        // perform depth-first search for words
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.children[ch - 'a'] != null) {
                word.append(ch);
                dfs(node.children[ch - 'a'], word, list);
                // backtrack to search for all words with same prefix
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    // Recursive function to delete a key from the Trie
    private boolean delete(TrieNode current, String word, int index) {
        // Base case: If the word's end is reached
        if (index == word.length()) {
            // If the word exists, unmark it and check if the node can be deleted
            if (current.isEnd) {
                current.isEnd = false;
                return current.children.length == 0; // Return true if no children exist
            }
            return false;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children[ch - 'a'];
        if (node == null) {
            return false; // Word not found
        }

        boolean shouldDeleteChild = delete(node, word, index + 1);

        // If true is returned, delete the child reference of the current TrieNode
        if (shouldDeleteChild) {
            current.children[ch - 'a'] = null;
            // Return true if no mappings are left in the map
            return current.children.length == 0;
        }

        return false;
    }

    // Function to delete a word from the Trie
    public void deleteWord(String word) {
        delete(root, word, 0);
    }
}
