package com.jesse.principles.interfaces.extendDemo2.extendDemo;

public class Main implements A, B {
    @Override
     public void greet() {

    }

    public static void main(String[] args) {
        Main obj = new Main();
        A.greeting();
    }
}
