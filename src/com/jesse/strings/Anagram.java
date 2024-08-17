package com.jesse.strings;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() < t.length() || t.length() < s.length()) {
            return false;
        }

        int[] arr1 = new int[s.length()];
        int[] arr2 = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            arr1[i] = s.codePointAt(i);
            arr2[i] = t.codePointAt(i);
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < s.length(); i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
