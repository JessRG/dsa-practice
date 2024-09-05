package com.jesse.dp;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = new int[] {1,6,10,16};
        int[] weights = new int[] {1,2,3,5};
        int capacity = 7;
//        profits = new int[] {1,6,10,16};
//        weights = new int[] {1,2,3,5};
//        capacity = 6;
        System.out.println(ks.solveKnapsack(profits, weights, capacity));
    }
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        return knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int index) {
        if (index >= profits.length) {
            return 0;
        }

        int profit1 = Integer.MIN_VALUE;
        if (weights[index] <= capacity) {
            profit1 = profits[index] + knapsackRecursive(profits, weights, capacity - weights[index], index + 1);
        }

        int profit2 = knapsackRecursive(profits, weights, capacity, index + 1);

        return Math.max(profit1, profit2);
    }
}
