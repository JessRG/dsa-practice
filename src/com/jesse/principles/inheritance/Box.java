package com.jesse.principles.inheritance;

public class Box {
    double l;
    double h;
    double w;

    public Box() {}

    // cube
    Box(double side) {
        this.w = side;
        this.l = side;
        this.h = side;
    }

    public Box(double l, double h, double w) {
        System.out.println("Box class constructor");
        this.l = l;
        this.h = h;
        this.w = w;
    }

    public Box(Box old) {
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }
}
