package com.jesse.arrays;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        LeftAndRightSumDifferences larsd = new LeftAndRightSumDifferences();
        int[] nums = new int[] {1,2,3,4};
        nums = new int[] {5,4,3,2,1};
        nums = new int[] {5, 5, 5, 5, 5};
        nums = new int[] {2, 5, 1, 6, 1};
        System.out.println(Arrays.toString(larsd.findDifferenceArray(nums)));
    }

    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        // TODO: Write your code here
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            differenceArray[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return differenceArray;
    }
}
