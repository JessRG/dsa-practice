package com.jesse.twoHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
//    public double[] findSlidingWindowMedian(int[] nums, int k) {
//        double[] result = new double[nums.length - k + 1];
//        // TODO: Write your code here
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        int start = 0;
//        for (int end = 0; end < nums.length; end++) {
//            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[end]) {
//                maxHeap.add(nums[end]);
//            } else {
//                minHeap.add(nums[end]);
//            }
//            if (maxHeap.size() > minHeap.size() + 1) {
//                minHeap.add(maxHeap.poll());
//            } else if (maxHeap.size() < minHeap.size()) {
//                maxHeap.add(minHeap.poll());
//            }
//
//            if (end >= k - 1) {
//                if (maxHeap.size() == minHeap.size()) {
//                    result[start] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
//                } else {
//                    result[start] = maxHeap.peek();
//                }
//                if (maxHeap.contains(nums[start])) {
//                    maxHeap.remove(nums[start]);
//                }
//                if (minHeap.contains(nums[start])) {
//                    minHeap.remove(nums[start]);
//                }
//                start++;
//            }
//        }
//        return result;
//    }

    // Alternative solution
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalanceHeaps();

            if (i - k + 1 >= 0) { // if we have at least 'k' elements in the sliding window
                // add the median to the the result array
                if (maxHeap.size() == minHeap.size()) {
                    // we have even number of elements, take the average of middle two elements
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else { // because max-heap will have one more element than the min-heap
                    result[i - k + 1] = maxHeap.peek();
                }

                // remove the element going out of the sliding window
                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                rebalanceHeaps();
            }
        }
        return result;
    }

    private void rebalanceHeaps() {
        // either both the heaps will have equal number of elements or max-heap will have
        // one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        int[] nums = new int[] {1, 2, -1, 3, 5};
        int k = 2;
        System.out.println(Arrays.toString(swm.findSlidingWindowMedian(nums, k)));
    }
}
