package com.jesse.arrays;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] arr = new int[capacity];

    public static int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    public static int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    public static int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    public boolean hasParent(int childIdx) {
        return getParentIdx(childIdx) >= 0;
    }

    public boolean hasLeftChild(int parentIdx) {
        return getLeftChildIdx(parentIdx) < size;
    }

    public boolean hasRightChild(int parentIdx) {
        return getRightChildIdx(parentIdx) < size;
    }

    private int parent(int index) {
        return arr[getParentIdx(index)];
    }

    private int leftChild(int index) {
        return arr[getLeftChildIdx(index)];
    }

    private int rightChild(int index) {
        return arr[getRightChildIdx(index)];
    }

    private void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return arr[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        arr[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > arr[index]) {
            swap(getParentIdx(index), index);
            index = getParentIdx(index);
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChildIndex =  getLeftChildIdx(index);

            // check if rightChild is less than leftChild
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIdx(index);
            }

            // check if current item is less than the smaller child item (left or right)
            if (arr[smallerChildIndex] < arr[index]) {
                swap(index, smallerChildIndex);
            } else {
                // the min heap property is not violated, so break the loop
                break;
            }

            index = smallerChildIndex;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
