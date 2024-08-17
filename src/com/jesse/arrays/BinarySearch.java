package com.jesse.arrays;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = new int[] {1, 2, 3, 4, 5};
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        System.out.println(binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target) {
        if (arr.length < 1) {
            return - 1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    // Recursive
    static int binarySearchR(int[] a, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (a[mid] == target) {
            return mid;
        }

        if (target < a[mid]) {
            return binarySearchR(a, target, start, mid - 1);
        }

        return binarySearchR(a, target, mid + 1, end);
    }
}
