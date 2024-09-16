package com.jesse.Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Function to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert character to index
            if (node.children[index] == null)
                node.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
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
        return node.isEndOfWord; // Return true if word exists, false otherwise
    }

    // Recursive function to delete a key from the Trie
    private boolean delete(TrieNode current, String word, int index) {
        // Base case: If the word's end is reached
        if (index == word.length()) {
            // If the word exists, unmark it and check if the node can be deleted
            if (current.isEndOfWord) {
                current.isEndOfWord = false;
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
