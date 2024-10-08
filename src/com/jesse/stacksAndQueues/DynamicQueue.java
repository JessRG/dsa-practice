package com.jesse.stacksAndQueues;

public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super(); // It will call CustomStack constructor ( CustomStack() )
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        // takes care of data array being full
        if (this.isFull()) {
            // double size of array
            int[] temp = new int[data.length * 2];

            // copy all previous items into new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }

            front = 0;
            end = data.length;
            data = temp;
        }

        return super.insert(item);
    }
}
