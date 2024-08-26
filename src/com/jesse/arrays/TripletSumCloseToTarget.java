package com.jesse.arrays;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        int[] arr = new int[] { -1, 0, 2, 3 };
        arr = new int[] { -3, -1, 1, 2 };
        arr = new int[] { 1, 0, 1, 1 };
        arr = new int[] { 0, 0, 1, 1, 2, 6 };
        int target = 3;
        target = 1;
        target = 100;
        target = 5;
        System.out.println(searchTriplet(arr, target));
    }

    public static int searchTriplet(int[] arr, int targetSum) {
        // TODO: Write your code here
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int minSum = -1;
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i+1;
            int end = arr.length - 1;

            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                int diff = Math.abs(targetSum - sum);

                if (sum == targetSum) {
                    return sum;
                }

                if (diff <= minDiff) {
                    if (diff == minDiff && sum < minSum) {
                        minSum = sum;
                    }
                    if (diff < minDiff) {
                        minSum = sum;
                    }

                    minDiff = diff;
                }

                if (targetSum > sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return minSum;
    }
}
