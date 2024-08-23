package com.jesse.arrays;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here
        int[] res = new int[] {-1, -1};

        if (arr == null || arr.length == 0) {
            return res;
        }

        int start = 0;
        int end = arr.length -1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < targetSum) {
                start++;
            } else if (sum > targetSum) {
                end--;
            } else {
                res[0] = start;
                res[1] = end;
                break;
            }
        }
        return res;
    }
}
