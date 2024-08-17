package com.jesse.arrays;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

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
        return getLeftChildIdx(parentIdx) < list.size();
    }

    public boolean hasRightChild(int parentIdx) {
        return getRightChildIdx(parentIdx) < list.size();
    }

    private T parent(int index) {
        return list.get(getParentIdx(index));
    }

    private T leftChild(int index) {
        return list.get(getLeftChildIdx(index));
    }

    private T rightChild(int index) {
        return list.get(getRightChildIdx(index));
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        return list.get(0);
    }

    public T poll() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty array!");
        }
        T item = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
        }
        heapifyDown();
        return item;
    }

    public void add(T item) {
        list.add(item);
        heapifyUp();
    }

    private void heapifyUp() {
        int index = list.size() - 1;

        while (hasParent(index) && list.get(index).compareTo(parent(index)) < 0) {
            swap(getParentIdx(index), index);
            index = getParentIdx(index);
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChildIndex =  getLeftChildIdx(index);

            // check if rightChild is less than leftChild
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIdx(index);
            }

            // check if current item is less than the smaller child item (left or right)
            if (list.get(smallerChildIndex).compareTo(list.get(index)) < 0) {
                swap(index, smallerChildIndex);
            } else {
                // the min heap property is not violated, so break the loop
                break;
            }

            index = smallerChildIndex;
        }
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while(!list.isEmpty()) {
            data.add(this.poll());
        }

        return data;
    }

    public static void main(String[] args) throws Exception{
        HeapRecursive heapRecursive = new HeapRecursive();
        heapRecursive.add(34);
        heapRecursive.add(45);
        heapRecursive.add(22);
        heapRecursive.add(89);
        heapRecursive.add(76);

//        heap.display();
//        System.out.println(heap.poll());
        System.out.println(heapRecursive.heapSort());
    }
}
