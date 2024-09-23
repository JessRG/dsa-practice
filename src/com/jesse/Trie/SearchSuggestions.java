package com.jesse.Trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestions {
    public static void main(String[] args) {
        String[] products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
        products = new String[] {"apple", "apricot", "application"};
        products = new String[] {"king", "kingdom", "kit"};
        String searchWord = "mouse";
        searchWord = "app";
        searchWord = "ki";

        for (List<String> suggestions : suggestedProducts(products, searchWord)) {
            System.out.println(suggestions);
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        // build Trie
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        // Set up prefix string and search for suggested products
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            result.add(trie.suggestionSearch(prefix.toString()));
        }

        return result;
    }

    public void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
}
