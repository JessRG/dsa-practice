package com.jesse.arrays;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap(9));
        System.out.println(binaryGap(15));
        System.out.println(binaryGap(20));
        System.out.println(binaryGap(32));
        System.out.println(binaryGap(529));
        System.out.println(binaryGap(1041));
    }

    static int binaryGap(int num) {
//        String binary = Integer.toBinaryString(num);
//
//        int max = 0;
//        int start = 0;
//        for (int i = 0; i < binary.length(); i++) {
//            if (binary.charAt(i) == '1') {
//                max = Math.max(max, i - start);
//                start = i+1;
//            }
//        }
//        return max;

        StringBuilder sb = new StringBuilder();
        int n = num;
        while(n > 0) {
            int r = n % 2;
            sb.append(r);
            n = n / 2;
        }

        int max = 0;
        int start = sb.toString().indexOf('1');
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                max = Math.max(max, i - start);
                start = i + 1;
            }
        }
        System.out.println(sb);

        return max;
    }
}
