package com.jesse.arrays;

public class SearchInMountain {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6, 4, 3, 2};
//        int[] arr = new int[] {1, 2, 3, 4, 5};
        int target = 4;
//        System.out.println(findPeakInMountainArray(arr));
//        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
        System.out.println(searchMountainArray(arr, target));
    }

    static int searchMountainArray(int[] arr, int target) {
        int peak = findPeakInMountainArray(arr);

        if (target == arr[peak]) {
            return peak;
        }

        int ans = binarySearch(arr, target, 0, peak - 1);

        if (ans == -1) {
            ans = binarySearch(arr, target, peak + 1, arr.length - 1);
        }
        return ans;
    }

    static int findPeakInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
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
}
