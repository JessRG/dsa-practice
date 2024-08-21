package com.jesse.strings;

public class ReverseVowels {
    public static void main(String[] args) {
//        String s = "hello";
        String s = "AEIOU";
//        String s = "DesignGUrus";
        System.out.print(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        // TODO: Write your code here
        int start = 0;
        int end = s.length() - 1;

        String vowels = "aeiouAEIOU";
        char[] ch = s.toCharArray();
        while (start < end) {
            while (vowels.indexOf(ch[start]) == -1 && start < end) {
                start++;
            }
            while (vowels.indexOf(ch[end]) == -1 && end > 0) {
                end--;
            }

            if (start < end) {
                // swap
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        s = new String(ch);
        return s;
    }
}
