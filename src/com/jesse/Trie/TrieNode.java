package com.jesse.Trie;

public class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Children nodes
    boolean isEndOfWord; // Flag to represent the end of a word

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}
