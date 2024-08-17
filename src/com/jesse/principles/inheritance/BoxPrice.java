package com.jesse.principles.inheritance;

public class BoxPrice extends BoxWeight{
    int l;
    int h;
    int w;
    int price;

    BoxPrice() {
        super();
        this.price = 0;
    }

    BoxPrice(int l, int h, int w) {
        super(l,h,w);
        this.price = 0;
    }

    BoxPrice(int l, int h, int w, int price) {
        super(l,h,w);
        this.price = price;
    }
}
