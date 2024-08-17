package com.jesse.principles.inheritance;

public class BoxWeight extends Box {
    int l;
    int h;
    int w;
    int weight;

    public BoxWeight() {
        super();
    }

    public BoxWeight(int l, int h, int w) {
        super(l, h, w);
        this.weight = -1;
    }
}
