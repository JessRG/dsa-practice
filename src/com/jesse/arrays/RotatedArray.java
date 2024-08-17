package com.jesse.arrays;

public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 5, 6, 7, 0, 1, 2};
        int target = 1;
//        System.out.println(searchRotatedArray(arr, target));
        System.out.println(findRotationCount(arr));
//        System.out.println(binarySearchR(arr, target, 0, arr.length - 1));
    }

    static int findRotationCount(int[] arr) {
        int pivot = findPivotWithDuplicates(arr);

        return pivot + 1;
    }

    static int searchRotatedArray(int[] arr, int target) {
        int pivot = findPivotWithDuplicates(arr);

        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        if (target == arr[pivot]) {
            return pivot;
        }

        if (target > arr[0]) {
            return binarySearch(arr, target, 0, pivot - 1);
        }

        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // if elements at the middle, start, and end are equal, then skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {

                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check if end is pivot
                if (arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end --;
            }

            // left side is sorted, so pivot should be in right
            if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if (arr.length < 1) {
            return - 1;
        }

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

//    static int binarySearchR(int[] a, int target, int start, int end) {
//        if (start > end) {
//            return -1;
//        }
//
//        int mid = start + (end - start) / 2;
//
//        if (a[mid] == target) {
//            return mid;
//        }
//
//        if (mid < end && a[mid] > a[mid + 1]) {
//            if (target >= a[start]) {
//                return binarySearchR(a, target, start, mid - 1);
//            } else {
//                return binarySearchR(a, target, mid + 1, end);
//            }
//        }
//
//        if (mid > start && a[mid] < a[mid - 1]) {
//            if (target >= a[start]) {
//                return binarySearchR(a, target, start, mid - 2);
//            } else {
//                return binarySearchR(a, target, mid, end);
//            }
//        }
//        return -1;
//    }
}
