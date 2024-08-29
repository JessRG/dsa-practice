package com.jesse.twoHeaps;

import java.util.PriorityQueue;

public class FindMedianOfNumberStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int size;
    public FindMedianOfNumberStream() {
        //TODO: Write your code here
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
        size = 0;
    }

    public void insertNum(int num) {
        // TODO: Write your code here
        if (!minHeap.isEmpty()) {
            while (!minHeap.isEmpty()) {
                Integer elem = minHeap.remove();
                maxHeap.add(elem);
            }
        }
        maxHeap.add(num);
        size++;
    }

    public double findMedian() {
        // TODO: Write your code here
        try {
            int len = size / 2;
            for (int i = 0; i < len; i++) {
                Integer elem = maxHeap.remove();
                minHeap.add(elem);
            }
            if (size % 2 == 0) {
                Integer min = minHeap.peek();
                Integer max = maxHeap.peek();
                return ((double) (min + max) / 2);
            } else {
                return (double) maxHeap.peek();
            }
        } catch (NullPointerException ex) {
            throw new NullPointerException("Peek operation is returning null");
        }
    }

    public static void main(String[] args) {
        FindMedianOfNumberStream fm = new FindMedianOfNumberStream();
        fm.insertNum(3);
        fm.insertNum(1);
        System.out.println(fm.findMedian()); // -> output: 2
        fm.insertNum(5);
        System.out.println(fm.findMedian()); // -> output: 3
        fm.insertNum(4);
        System.out.println(fm.findMedian()); // -> output: 3.5

//        [3,1]
//        [5,1,4]
//        [1,2,3,4,5]
    }
}
