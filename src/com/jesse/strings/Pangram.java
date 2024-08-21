package com.jesse.strings;

import java.util.HashSet;

public class Pangram {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(checkIfPangram(str));
    }

    public static boolean checkIfPangram(String sentence) {
        // TODO: Write your code here
        // Create HashSet
        HashSet<Character> set = new HashSet<>();
//        char[] ch = sentence.toCharArray();
//        int range = 'z' - 'a';
//        for (int i = 0; i < ch.length; i++) {
//            char c = Character.toLowerCase(ch[i]);
//            int val = c - 'a';
//            if (val <= range && val >= 0) {
//                set.add(c);
//            }
//        }
        for (char ch : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                set.add(ch);
            }
        }

        return set.size() == 26;
    }
}
