package com.jesse.prefixSum;

public class GetMinimumErrors {
    public static void main(String[] args) {
        String s = "101!1";
        s = "01!0";
        s = "!!!!!!!";
        int x = 2;
        int y = 3;
        y = 2;
        x = 23;
        y = 27;

        System.out.println(getMinErrors(s, x, y));
    }

    public static int getMinErrors(String errorString, int x, int y) {
        // write your code here
        return Math.min(getErrors(errorString.replace("!", "0"), x, y), getErrors(errorString.replace("!", "1"), x, y));
    }

    private static int getErrors(String s, int x, int y) {
        int[] zeroes = new int[s.length()];
        int[] ones = new int[s.length()];

        // set first elements in zeroes and ones prefix arrays
        zeroes[0] = s.charAt(0) == '0' ? 1 : 0;
        ones[0] = s.charAt(0) == '1' ? 1 : 0;

        // calculate zeroes and ones prefix arrays;
        for (int i = 1; i < s.length(); i++) {
            ones[i] = ones[i - 1] + ((s.charAt(i) == '1') ? 1 : 0);
            zeroes[i] = zeroes[i - 1] + ((s.charAt(i) == '0') ? 1 : 0);
        }

        // iterate through string s and calculate counts for 01s and 10s using prefix arrays
        int zeroOne = 0;
        int oneZero = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                oneZero += ones[i - 1];
            } else {
                zeroOne += zeroes[i - 1];
            }
        }

        return (zeroOne * x) + (oneZero * y);
    }
}
