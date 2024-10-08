package com.jesse.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal, Panama!";
        String s = "race a car";
//        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
    }

    // My first solution
//    public static boolean isPalindrome(String s) {
//        // TODO: Write your code here
//        // replace all non alphanumeric characters
//        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//        int start = 0;
//        int end = s.length() - 1;
//
//        // check left side of the string with the right side of the string
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

        public static boolean isPalindrome(String s) {
        // TODO: Write your code here
        int start = 0;
        int end = s.length() - 1;

        // check left side of the string with the right side of the string
        while (start < end) {
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
