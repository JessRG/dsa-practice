package com.jesse.stacksAndQueues;

public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super(); // It will call CustomStack constructor ( CustomStack() )
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        // takes care of data array being full
        if (this.isFull()) {
            // double size of array
            int[] temp = new int[data.length * 2];

            // copy all previous items into new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;

        }

        // at this point we know that data array is not full
        return super.push(item);
    }
}
