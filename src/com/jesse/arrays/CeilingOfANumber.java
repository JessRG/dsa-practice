package com.jesse.arrays;

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr = new int[] {4,6,10};
//        arr = new int[] {1,3,8,10,15};
//
        int key = 6;
            key = 10;
        key = 12;
        key = 17;
        key = -1;
        System.out.println(searchCeilingOfANumber(arr, key));
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {
        // TODO: Write your code here
        if (key > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < key ) {
                start = mid + 1;
            }
            else if (arr[mid] > key) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return start;
    }
}
