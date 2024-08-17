package com.jesse.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 2, 3, 1};
//        System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] ans = new int[first.length + second.length];

        int lPtr = 0;
        int rPtr = 0;
        int k = 0;

        while (lPtr < first.length && rPtr < second.length) {
            if (first[lPtr] <= second[rPtr]) {
                ans[k] = first[lPtr];
                lPtr++;
            } else {
                ans[k] = second[rPtr];
                rPtr++;
            }
            k++;
        }

        // add remaining elements from either first or second array
        while (lPtr < first.length) {
            ans[k] = first[lPtr];
            lPtr++;
            k++;
        }

        while (rPtr < second.length) {
            ans[k] = second[rPtr];
            rPtr++;
            k++;
        }

        return ans;
    }



    static void mergeSortInPlace(int[] arr, int s, int e) {
        if(e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid); // left
        mergeSortInPlace(arr, mid, e); // right

        mergeInPlace(arr, s, mid, e); // merge left and right
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int s = start;
        int m = mid;
        int k = 0;
        while (s < mid && m < end) {
            if (arr[s] <= arr[m]) {
                mix[k] = arr[s];
                s++;
            } else {
                mix[k] = arr[m];
                m++;
            }
            k++;
        }

        // add remaining elements from either first or second array
        while (s < mid) {
            mix[k] = arr[s];
            s++;
            k++;
        }

        while (m < end) {
            mix[k] = arr[m];
            m++;
            k++;
        }

        for(int i = 0; i < mix.length; i++) {
            arr[start + i] = mix[i];
        }
    }
}
