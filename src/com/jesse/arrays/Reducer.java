package com.jesse.arrays;

import java.util.PriorityQueue;

public class Reducer {

    public static void main(String[] args) {
        System.out.println(reduce(new int[] { 2, 2, 3, 3 }));
    }

    private static int reduce(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int elem : arr) {
            q.add(elem);
        }

        int temp;
        int cost = 0;
        while (q.size() > 1) {
            int first = q.poll();
            int second = q.poll();

            temp = first + second;
            cost += temp;
            q.offer(temp);
        }

        return cost;
    }

//    private static int reduceRet(int[] arr) {
//        return reduceHelper(arr, 2);
//    }
//
//    private static int reduceHelper(int[] a, int cost) {
//
//    }
}
