package com.jesse.algorithms;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(27));
    }

    public static int mySqrt(int x) {
        // TODO: Write your code here
        if (x <= 0) {
            return 0;
        }
        // Babylonian Method -> The Heron's Method
        double guess = x / 2d;
        double precision = 0.0001;
        double sqrt;
        while(true) {
            sqrt = (guess + x / guess) / 2;
            if (Math.abs(sqrt - guess) < precision) {
                break;
            }
            guess = sqrt;
        }

        return (int)sqrt;
    }
}
