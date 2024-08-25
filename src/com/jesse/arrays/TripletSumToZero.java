package com.jesse.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static void main(String[] args) {
//        int[] arr = new int[] { -3, 0, 1, 2, -1, 1, -2 };
        int[] arr = new int[] { -5, 2, -1, -2, 3 };
//        int[] arr = new int[] { 0, 0, 0 };
//        int[] arr = new int[] { -1, 0, 1, 0 };
//        int[] arr = new int[] { -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6 };
//        int[] arr = new int[] { -1,-1,0,1,2,3 };
//        int[] arr = new int[] { -1,-1,-1,2 };
        System.out.println(Arrays.toString(searchTriplets(arr).toArray()));
    }

    // Improved solution
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        // TODO: Write your code here
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int targetSum = -arr[i];
            int start = i+1;
            int end = arr.length - 1;
            searchPair(arr, targetSum, start, end, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int start, int end, List<List<Integer>> triplets) {
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < targetSum) {
                start++;
            } else if (sum > targetSum) {
                end--;
            } else {
                triplets.add(Arrays.asList(-targetSum, arr[start], arr[end]));
                start++;
                end--;

                // skip duplicates with start pointer
                while (start < end && arr[start] == arr[start - 1]) {
                    start++;
                }
                // skip duplicates with end pointer
                while (start < end && arr[end] == arr[end + 1]) {
                    end--;
                }
            }
        }
    }

//    public static List<List<Integer>> searchTriplets(int[] arr) {
//        List<List<Integer>> triplets = new ArrayList<>();
//        // TODO: Write your code here
//        Arrays.sort(arr);
//        int start = 0;
//        int end = arr.length - 1;
//
//        int mid = start + (end - start) / 2;
//        if (arr[mid] < 0) {
//            while (arr[mid] < 0 && mid < end - 1) {
//                mid++;
//            }
//        } else {
//            while (arr[mid] > 0 && arr[mid - 1] > 0 ) {
//                mid--;
//            }
//        }
//        HashSet<List<Integer>> unique = new HashSet<>();
//
//        while (mid < end && start < mid ) {
//            search(arr, triplets, unique, start, mid, end);
//            if (end - mid > mid - start) {
//                end--;
//            } else {
//                start++;
//            }
//        }
//        return triplets;
//    }
//
//    private static void search(int[] arr, List<List<Integer>> triplets, HashSet<List<Integer>> unique, int start, int mid, int end) {
//        int s = start;
//        int e = end;
//        int m = mid;
//        // search left side
//        while (s < m) {
//            int sum = arr[s] + arr[m] + arr[e];
//            if (sum > 0) {
//                m--;
//            } else if (sum < 0) {
//                s++;
//            } else {
//                List<Integer> triplet = new ArrayList<>();
//                triplet.add(arr[s]);
//                triplet.add(arr[m]);
//                triplet.add(arr[e]);
//                if (unique.add(triplet)) {
//                    triplets.add(triplet);
//                }
//                m--;
//            }
//        }
//        s = start;
//        m = mid;
//        // search right side
//        while (m < e) {
//            int sum = arr[s] + arr[m] + arr[e];
//            if (sum > 0) {
//                e--;
//            } else if (sum < 0) {
//                m++;
//            } else {
//                List<Integer> triplet = new ArrayList<>();
//                triplet.add(arr[s]);
//                triplet.add(arr[m]);
//                triplet.add(arr[e]);
//                if (unique.add(triplet)) {
//                    triplets.add(triplet);
//                }
//                m++;
//            }
//        }
//    }
}
