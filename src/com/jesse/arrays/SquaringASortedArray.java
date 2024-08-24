package com.jesse.arrays;

import java.util.Arrays;

public class SquaringASortedArray {
    public static void main(String[] args) {
//        int[] arr = new int[] {-2, -1, 0, 2, 3};
        int[] arr = new int[] {-3, -1, 0, 1, 2};
//        int[] arr = new int[] {-4, -2, 0, 2, 4};
        System.out.println(Arrays.toString(makeSquares(arr)));
    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        // TODO: Write your code here
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            squares[i] = num * num;
        }
        Arrays.sort(squares);
        return squares;
    }
}
