package com.jesse.Trie;

// Extra Characters in a String
public class ExtraCharacters {
    public static void main(String[] args) {
        String[] dictionary = new String[] {"program", "test", "java", "python"};
        String word = "programmingtest";
//        word = "javaandpython";
        System.out.println(minExtraChars(dictionary, word));
    }

    private static int minExtraChars(String[] dictionary, String text) {
        // build trie from dictionary
        int n = text.length();
        TrieNode root = buildTrie(dictionary);
        int[] dp = new int[n+1]; // dp array stores minimum extra characters

        // calculate dp array; iterate over text string in reverse
        for (int s = n - 1; s >= 0; s--) {
            dp[s] = dp[s + 1] + 1; // Default case: considering current character as extra.

            TrieNode node = root;
            for (int e = s; e < text.length(); e++) {
                char c = text.charAt(e);
                if (node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c - 'a'];

                if (node.isEnd) {
                    // update dp if word is found
                    dp[s] = Math.min(dp[s], dp[e+1]);
                }
            }
        }

        return dp[0];
    }

    private static TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }
}
