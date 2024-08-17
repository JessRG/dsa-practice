package com.jesse.strings;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n < 0) return "";

        String s = "1";
        while(n > 1) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < s.length(); ++i) {
                int count = 1;
                while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    ++count;
                    ++i;
                }
                result.append(count).append(s.charAt(i));
            }
            s = result.toString();
            --n;
        }

        return s;
    }
}
