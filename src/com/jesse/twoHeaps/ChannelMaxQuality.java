package com.jesse.twoHeaps;


import java.util.*;

// You are given a list of packets of varying sizes and there are n channels.
//
// Each of the n channel must have a single packet
// Each packet can only be on a single channel
// The quality of a channel is described as the median of the packet sizes on that channel. The total quality is defined as sum of the quality of all channels (round to integer in case of float).
//
// Given the packet sizes and num of channels, find the maximum quality.
//
//        Function Description
//
// Complete the function calculateMedianSum in the editor.
//
// calculateMedianSum has the following parameters:
// int[] packets: an array of integers
// int n: the number of channels
//
// Returns
// int: the sum of the medians of each channel

public class ChannelMaxQuality {

    public static void main(String[] args) {
        List<Integer> packets = Arrays.asList(1, 2, 3, 4, 5);
        packets = Arrays.asList(5, 2, 2, 1, 5, 3);
        int n = 2;

        System.out.println(calculateMedianSum(packets, n));
        System.out.println(calculateMedianSumWithoutSort(packets, n));
    }

    public static long calculateMedianSum(List<Integer> packets, int n) {
        // write your code here
        // sort packets in descending order
        Collections.sort(packets, (a, b) -> b - a);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int m = packets.size();
        long ans = 0;

        // fill each channel excluding the last channel with at least one packet (start with largest packets)
        for (int i = 0; i < n - 1; i++) {
            ans += packets.get(i);
        }

        // populate heaps with the subsequent packets (to calculate median for the last channel)
        for (int i = n - 1; i < m; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() > packets.get(i)) {
                maxHeap.add(packets.get(i));
            } else {
                minHeap.add(packets.get(i));
            }

            // rebalance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        // add median of the last channel
        if (minHeap.size() == maxHeap.size()) {
            ans += (long) Math.ceil((minHeap.peek() + maxHeap.peek()) / 2.0);
        } else {
            ans += maxHeap.peek();
        }

        return ans;
    }

    public static long calculateMedianSumWithoutSort(List<Integer> packets, int n) {
        // write your code here

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int m = packets.size();
        long ans = 0;

        // populate heap with all packets
        for (int i = 0; i < m; i++) {
            maxHeap.add(packets.get(i));
        }

        // remove largest packets from max heap and add to each channel (excluding the last channel)
        for (int i = 0; i < n - 1; i++) {
            ans += maxHeap.poll();
        }

        // balance both heaps
        if (maxHeap.size() % 2 == 0) {
            while (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        } else {
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
        }

        // add median of the last channel
        if (minHeap.size() == maxHeap.size()) {
            ans += (long) Math.ceil((minHeap.peek() + maxHeap.peek()) / 2.0);
        } else {
            ans += maxHeap.peek();
        }

        return ans;
    }
}
