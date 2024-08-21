package com.jesse.patterns;

public class Patterns {
    public static void main(String[] args) {
        pattern2dArray(4);
    }
    static void pattern2dArray(int n) {
        int originalN = n;
        n = 2 * n - 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int atIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row - 1, n - col - 1));
                System.out.print(atIndex + " ");
            }
            System.out.println();
        }
    }
}
