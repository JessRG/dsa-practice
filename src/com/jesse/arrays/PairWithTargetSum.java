package com.jesse.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class PairWithTargetSum {
    public static void main(String[] args) {
//        int[] arr = new int[] {1, 2, 3, 4, 6};
//        int target = 6;
        int[] arr = new int[] {2, 5, 9, 11};
        int target = 11;
//        int[] arr = new int[] {1, 3, 5, 7, 9};
//        int target = 16;

        System.out.println(Arrays.toString(search(arr, target)));
        System.out.println(Arrays.toString(searchWithMap(arr, target)));
    }

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

    public static int[] searchWithMap(int[] arr, int targetSum) {
        // TODO: Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(targetSum - arr[i])) {
                return new int[] { map.get(targetSum - arr[i]), i };
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[] { -1, -1 };
    }
}
