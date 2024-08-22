package com.jesse.strings;

public class ShortestWordDistance {
    public static void main(String[] args) {
//        String[] words = new String[] {"the","quick","brown","fox","jumps","over","the","lazy","dog"};
//        String word1 = "fox";
//        String word2 = "dog";

//        String[] words = new String[] {"a","b","c","d","a","b"};
//        String word1 = "a";
//        String word2 = "b";

//        String[] words = new String[] {"a","c","d","b","a"};
//        String word1 = "a";
//        String word2 = "b";

        String[] words = new String[] {"repeated", "words", "in", "the", "array", "words"};
        String word1 = "repeated";
        String word2 = "words";

        System.out.println(shortestDistance(words, word1, word2));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        // TODO: Write your code here
        if (words.length == 0) {
            return 0;
        }
        if (word1.equals(word2)) {
            return 0;
        }
        int distance = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                idx1 = i;
            }
            if (word2.equals(words[i])) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                distance = Math.min(distance, Math.abs(idx2 - idx1));
            }
        }
        return distance;
    }
}
