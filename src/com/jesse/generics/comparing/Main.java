package com.jesse.generics.comparing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student kunal = new Student(12, 89.76f);
        Student rahul = new Student(5, 99.52f);
        Student karan = new Student(5, 77.52f);
        Student sachin = new Student(5, 96.52f);

        Student[] list = { kunal, rahul, karan, sachin };

        System.out.println(Arrays.toString(list));
        Arrays.sort(list, (o1, o2) -> -(int) (o1.marks - o2.marks));
        System.out.println(Arrays.toString(list));

//        if (kunal.compareTo(rahul) < 0) {
//            System.out.println("Rahul has more marks");
//        }
    }
}
