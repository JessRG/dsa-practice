package com.jesse.dp;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = new int[] {1,6,10,16};
        int[] weights = new int[] {1,2,3,5};
        int capacity = 7;
//        profits = new int[] {1,6,10,16};
//        weights = new int[] {1,2,3,5};
        capacity = 6;
        System.out.println(ks.solveKnapsack(profits, weights, capacity));
        System.out.println(ks.solveKnapsackTabulation(profits, weights, capacity));
    }
//    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
//        // TODO: Write your code here
//        return knapsackRecursive(profits, weights, capacity, 0);
//    }
//
//    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int index) {
//        if (capacity <= 0 || index >= profits.length) {
//            return 0;
//        }
//
//        int profit1 = Integer.MIN_VALUE;
//        if (weights[index] <= capacity) {
//            profit1 = profits[index] + knapsackRecursive(profits, weights, capacity - weights[index], index + 1);
//        }
//
//        int profit2 = knapsackRecursive(profits, weights, capacity, index + 1);
//
//        return Math.max(profit1, profit2);
//    }

    // ** Memoization solution **
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        int[][] dp = new int[profits.length][capacity + 1];
        return knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[][] dp, int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index >= profits.length) {
            return 0;
        }

        if (dp[index][capacity] != 0) {
            return dp[index][capacity];
        }

        int profits1 = Integer.MIN_VALUE;
        if (weights[index] <= capacity) {
            profits1 = profits[index] + knapsackRecursive(dp, profits, weights, capacity - weights[index], index + 1);
        }

        int profits2 = knapsackRecursive(dp, profits, weights, capacity, index + 1);

        dp[index][capacity] = Math.max(profits1, profits2);
        return dp[index][capacity];
    }

    // ** Tabulation solution **
    public int solveKnapsackTabulation(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity == 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        // process all sub-arrays for all the
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2;
                // include item if it is not greater than the capacity
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                profit2 = dp[i-1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);

        return dp[n-1][capacity];
    }

    private void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity) {
        System.out.print("Selected weights:");
        int totalProfit = dp[profits.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " +weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0) {
            System.out.print(" " + weights[0]);
        }
        System.out.println("");
    }
}
