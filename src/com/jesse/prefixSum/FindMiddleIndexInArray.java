package com.jesse.prefixSum;

public class FindMiddleIndexInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 7, 3, 6, 5, 6};
        arr = new int[] {2, 3, 5, 5, 3, 2};
        arr = new int[] {2, 1, -1};

        System.out.println(findMiddleIndex(arr));
    }

    // Method to find the index where the sum of elements to the left equals the sum of elements to the right
    public static int findMiddleIndex(int[] nums) {
        // ToDo: Write Your Code Here.
        int totalSum = 0;
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int rightSum;
        for (int i = 0; i < nums.length; i++) {
            rightSum = totalSum - leftSum - nums[i];

            if (rightSum == leftSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }

        return -1;
    }
}
