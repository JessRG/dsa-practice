package com.jesse.dp;

public class EqualSubSetSumPartition {
    public static void main(String[] args) {
        int[] num = new int[] {1, 2, 3, 4};
//        num = new int[] {1, 1, 3, 4, 7};
//        num = new int[] {2, 3, 4, 6};
        System.out.println(canPartition(num));
        System.out.println(canPartitionTabulation(num));
    }

//    public static boolean canPartition(int[] num) {
//        //TODO: Write - Your - Code
//        if (num.length == 0) {
//            return false;
//        }
//
//        // calculate the total sum
//        int totalSum = 0;
//        for (int val : num) {
//            totalSum += val;
//        }
//
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//        return partition(num, totalSum / 2, 0);
//    }
//
//    private static boolean partition(int[] num, int sum, int index) {
//        if (sum == 0) {
//            return true;
//        }
//        if (index >= num.length) {
//            return false;
//        }
//
//        if (num[index] <= sum) {
//            if (partition(num, sum - num[index], index + 1)) {
//                return true;
//            }
//        }
//
//        return partition(num, sum, index + 1);
//    }

    // ** Top-down Approach (Memoization) **
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

        Boolean[][] dp = new Boolean[num.length][totalSum / 2 + 1];
        return partition(dp, num, totalSum / 2, 0);
    }

    private static boolean partition(Boolean[][] dp, int[] num, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (index >= num.length) {
            return false;
        }

        if (dp[index][sum] == null) {
            if (num[index] <= sum) {
                if (partition(dp, num, sum - num[index], index + 1)) {
                    dp[index][sum] = true;
                    return true;
                }
            }
        }

        dp[index][sum] = partition(dp, num, sum, index + 1);

        return dp[index][sum];
    }

    // ** Bottom-up Approach (Tabulation) **
    public static boolean canPartitionTabulation(int[] num) {
        //TODO: Write - Your - Code
        if (num.length == 0) {
            return false;
        }
        int n = num.length;

        // calculate the total sum
        int totalSum = 0;
        for (int val : num) {
            totalSum += val;
        }

        if (totalSum % 2 != 0) {
            return false;
        }
        int sum = totalSum / 2;
        Boolean[][] dp = new Boolean[n][sum + 1];

        // populate the sum=0 columns, as we can always for '0' sum with an empty set
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // with only one number, we can form a subset only when the required sum is equal to
        // its value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = s == num[0];
        }

        // process all subsets
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i-1][s]) {
                    dp[i][s] = true;
                } else if (s >= num[i]) {
                    // else we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s - num[i]];
                }
            }
        }

        // bottom right corner will be our answer
        return dp[n-1][sum];
    }
}
