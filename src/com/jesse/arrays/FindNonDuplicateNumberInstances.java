package com.jesse.arrays;

public class FindNonDuplicateNumberInstances {
    public static void main(String[] args) {
//        int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
//        int[] arr = new int[] {2, 2, 2, 11};
        int[] arr = new int[] {1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println(moveElements(arr));
    }

    public static int moveElements(int[] arr) {
        // TODO: Write your code here
        int start = 0;
        int end = start + 1;

        while (end < arr.length) {
            if (arr[start] != arr[end]) {
                if (end - start > 1) {
                    start++;
                    swap(arr, start, end);
                    end++;
                } else {
                    start++;
                    end++;
                }
            } else {
                end++;
            }
        }
        return start+1;
    }

    private static void swap(int[] a, int s, int e) {
        int temp = a[s];
        a[s] = a[e];
        a[e] = temp;
    }
}
