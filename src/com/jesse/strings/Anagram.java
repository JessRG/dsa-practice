package com.jesse.strings;

import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
//        String s = "listen";
//        String t = "silent";
//        String s = "anagram";
//        String t = "nagaram";
//        String s = "hello";
//        String t = "world";
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() < t.length() || t.length() < s.length()) {
//            return false;
//        }
//
//        int[] arr1 = new int[s.length()];
//        int[] arr2 = new int[s.length()];
//
//        for(int i = 0; i < s.length(); i++) {
//            arr1[i] = s.codePointAt(i);
//            arr2[i] = t.codePointAt(i);
//        }
//
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//        for (int i = 0; i < s.length(); i++) {
//            if (arr1[i] != arr2[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        char[] first = s.toCharArray();
//        char[] second = t.toCharArray();
//        Arrays.sort(first);
//        Arrays.sort(second);
//
//        for (int i = 0; i < first.length; i++) {
//            if (first[i] != second[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            fmap.put(s.charAt(i), fmap.getOrDefault(s.charAt(i), 0) + 1);
            fmap.put(t.charAt(i), fmap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (char key : fmap.keySet()) {
            if (fmap.get(key) != 0) {
                return false;
            }
        }

        return true;
    }
}
