package com.jesse.dp;

public class EqualSubSetSumPartition {
    public static void main(String[] args) {
        int[] num = new int[] {1, 2, 3, 4};
//        num = new int[] {1, 1, 3, 4, 7};
//        num = new int[] {2, 3, 4, 6};
        System.out.println(canPartition(num));
    }

    public static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        if (num.length == 0) {
            return false;
        }

        // calculate the total sum
        int totalSum = 0;
        for (int val : num) {
            totalSum += val;
        }

        if (totalSum % 2 != 0) {
            return false;
        }
        return partition(num, totalSum / 2, 0);
    }

    private static boolean partition(int[] num, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (index >= num.length) {
            return false;
        }

        if (num[index] <= sum) {
            if (partition(num, sum - num[index], index + 1)) {
                return true;
            }
        }

        return partition(num, sum, index + 1);
    }
}
