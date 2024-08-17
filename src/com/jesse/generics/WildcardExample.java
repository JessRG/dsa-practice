package com.jesse.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// here T should either be Number or its subclasses
public class WildcardExample<T extends Number> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public WildcardExample() {
        data = new Object[DEFAULT_SIZE];
    }

    public void getList(List<? extends Number> list) {}

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        // copy current items into the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove() {
        T removed = (T)data[--size];
        return removed;
    }

    public T get(int index) {
        return (T)data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList(" +
                "data=" + Arrays.toString(data) +
                ", size=" + size + ')';
    }

    public static void main(String[] args) {
        WildcardExample<Integer> list = new WildcardExample<>();
//        list.add(3);
//        list.add(5);
//        list.add(9);

        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("dfhgj");
    }
}
