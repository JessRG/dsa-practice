package com.jesse.arrays;
import java.util.ArrayList;

public class HeapRecursive<T extends Comparable<T>> {

    private ArrayList<T> list;

    public HeapRecursive() {
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
            heapifyDown(0);
        }

        return item;
    }

    public void add(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }

        int p = getParentIdx(index);
        if (list.get(index).compareTo(parent(index)) > 0) {
            swap(index, p);
            heapifyUp(p);
        }
    }

    private void heapifyDown(int index) {
        int max = index;
        int left = getLeftChildIdx(index);
        int right = getRightChildIdx(index);

        if (hasLeftChild(index) && leftChild(index).compareTo(list.get(max)) > 0) {
            max = left;
        }

        if (hasRightChild(index) && rightChild(index).compareTo(list.get(max)) > 0) {
            max = right;
        }

        if (max != index) {
            swap(index, max);
            heapifyDown(max);
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

    public HeapRecursive buildHeap(ArrayList<T> arr) {
        if (arr.size() == 0) {
            return null;
        }

        for (int i = arr.size() / 2; i > 0; i--) {
            add(arr.get(i));
        }

        return this;
    }

    public static void main(String[] args) throws Exception{
        HeapRecursive maxHeap = new HeapRecursive();
        int[] arr = new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        maxHeap.buildHeap(list);
        maxHeap.display();

//        maxHeap.add(34);
//        maxHeap.add(45);
//        maxHeap.add(22);
//        maxHeap.add(89);
//        maxHeap.add(76);

//        heap.display();
//        System.out.println(heap.poll());
//        System.out.println(maxHeap.heapSort());
    }
}

