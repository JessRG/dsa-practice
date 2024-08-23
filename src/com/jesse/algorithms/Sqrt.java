package com.jesse.algorithms;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(27));
    }

//    public static int mySqrt(int x) {
//        // TODO: Write your code here
//        if (x <= 0) {
//            return 0;
//        }
//        // Babylonian Method -> The Heron's Method
//        double guess = x / 2d;
//        double precision = 0.0001;
//        double sqrt;
//        while(true) {
//            sqrt = (guess + x / guess) / 2;
//            if (Math.abs(sqrt - guess) < precision) {
//                break;
//            }
//            guess = sqrt;
//        }
//
//        return (int)sqrt;
//    }

    // Improved solution
    public static int mySqrt(int x) {
        // TODO: Write your code here
        if (x < 2) {
            return x;
        }

        int start = 2;
        int end = x / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long num = (long) mid * mid;

            if (num < x) {
                start = mid + 1;
            } else if (num > x) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
