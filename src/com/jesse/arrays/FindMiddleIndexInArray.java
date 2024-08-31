package com.jesse.arrays;

public class FindMiddleIndexInArray {
    public static void main(String[] args) {
        FindMiddleIndexInArray fmi = new FindMiddleIndexInArray();
        int[] arr = new int[] { 1, 7, 3, 6, 5, 6 };
        arr = new int[] { 2, 1, -1 };
        arr = new int[] { 2, 3, 5, 5, 3, 2 };
        System.out.println(fmi.findMiddleIndex(arr));
    }

    // Method to find the index where the sum of elements to the left equals the sum of elements to the right
    public int findMiddleIndex(int[] nums) {
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
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
