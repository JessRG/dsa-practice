package com.jesse.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {9, 3, 9, 3, 9, 7, 9};
//        int[] arr = { 42 };
        int[] arr = { 2, 2, 3, 3, 4};

        if (arr.length == 1) {
            System.out.println(arr[0]);
        } else {
            quickSort(arr, 0, arr.length - 1);
            int i = 0;
            while (arr.length > 2 && i < arr.length - 1) {
                int even = arr[i] % arr[i+1];
                if (even != 0) {
                    System.out.println(arr[i]);
                    break;
                }
                i += 2;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println(arr[arr.length - 1]);
        }
    }

    static void quickSort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        // place pivot in correct position
        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                swap(nums, s, e);
                s++;
                e--;
            }
        }

        // sort the left and right halves
        quickSort(nums, low, e);
        quickSort(nums, s, hi);
    }

    static void swap(int[] arr, int first, int second) {
        if (first == second) {
            return;
        }
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
