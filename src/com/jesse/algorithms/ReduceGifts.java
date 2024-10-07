package com.jesse.algorithms;

import java.util.Arrays;

//    New Year's Day is around the corner and Amazon is having a sale.
//    They have a list of items they are considering but they may need to remove some of them.
//    Determine the minimum number of items to remove from an array of prices so that the sum of prices of any k items
//    does not exceed a threshold.
//
//    Note: If the number of items in the list is less than k, then there is no need to remove any more items.
//
//    Function Description
//
//    Complete the function reduceGifts in the editor.
//
//    reduceGifts has the following parameters:
//      1. int prices[n]: the prices of each item
//      2. int k: the number of items to sum
//      3. int threshold: the maximum price of k items
//
//    Returns
//    int: the minimum number of items to remove
public class ReduceGifts {
    public static void main(String[] args) {
        int[] prices = new int[] {3, 2, 1, 4, 6, 5};
        int k = 3;
        int threshold = 14;

        System.out.println(reduceGifts(prices, k, threshold));
    }

    public static int reduceGifts(int[] prices, int k, int threshold) {
        // write your code here
        if (k > threshold) {
            return prices.length - k + 1;
        }
        Arrays.sort(prices);
        reverse(prices);

        int start = 0;
        int sum = 0;
        int removedItems = 0;
        for (int end = 0; end < prices.length; end++) {
            int windowSize = end - start;
            if (windowSize > 0 && (windowSize % k == 0 || sum > threshold)) {
                if (sum > threshold) {
                    removedItems++;
                }
                sum -= prices[start];
                start++;
            }

            sum += prices[end];
        }
        return removedItems;
    }

    private static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
