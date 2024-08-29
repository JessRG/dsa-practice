package com.jesse.twoHeaps;

import java.util.PriorityQueue;

public class FindMedianOfNumberStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
//    int size;
//    public FindMedianOfNumberStream() {
//        //TODO: Write your code here
//        maxHeap = new PriorityQueue<>((a, b) -> b - a);
//        minHeap = new PriorityQueue<>();
//        size = 0;
//    }
//
//    public void insertNum(int num) {
//        // TODO: Write your code here
//        if (!minHeap.isEmpty()) {
//            while (!minHeap.isEmpty()) {
//                Integer elem = minHeap.remove();
//                maxHeap.add(elem);
//            }
//        }
//        maxHeap.add(num);
//        size++;
//    }
//
//    public double findMedian() {
//        // TODO: Write your code here
//        try {
//            int len = size / 2;
//            for (int i = 0; i < len; i++) {
//                Integer elem = maxHeap.remove();
//                minHeap.add(elem);
//            }
//            if (size % 2 == 0) {
//                Integer min = minHeap.peek();
//                Integer max = maxHeap.peek();
//                return ((double) (min + max) / 2);
//            } else {
//                return (double) maxHeap.peek();
//            }
//        } catch (NullPointerException ex) {
//            throw new NullPointerException("Peek operation is returning null");
//        }
//    }

    // Improved solution
    public FindMedianOfNumberStream() {
        //TODO: Write your code here
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
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
