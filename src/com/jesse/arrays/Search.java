package com.jesse.arrays;

import java.util.ArrayList;

public class Search {
    public static void main(String[] args) {
        int [] arr = { 2, 3, 1, 4, 4, 5};
        int target = 44;
//        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearchLast(arr, target, arr.length - 1));
        findAllIndex(arr, 4, 0);
        System.out.println(list);
    }

    static int binarySearch(int[] a, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (a[mid] == target) {
            return mid;
        }

        if (target < a[mid]) {
            return binarySearch(a, target, start, mid - 1);
        }

        return binarySearch (a, target, mid + 1, end);
    }

    static boolean linearSearch(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }

        return arr[index] == target || linearSearch(arr, target, index+1);
    }

    static boolean linearSearchLast(int[] arr, int target, int index) {
        if (index == -1) {
            return false;
        }

        return arr[index] == target || linearSearchLast(arr, target, index-1);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        findAllIndex(arr, target, index + 1);
    }

    static ArrayList findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndex(arr, target, index + 1, list);
    }
}
