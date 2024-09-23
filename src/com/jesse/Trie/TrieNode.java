package com.jesse.Trie;

public class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Children nodes
    boolean isEnd; // Flag to represent the end of a word

    public TrieNode() {
        isEnd = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}
