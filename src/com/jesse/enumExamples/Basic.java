package com.jesse.enumExamples;

public class Basic {
    enum Week implements A {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // public, static and final
        // since it is final you can create child enums
        // type is Week

        Week() {
            System.out.println("Constructor called for " + this);
        }

        @Override
        public void hello() {
            System.out.println("Hey how are you");
        }
        // this is not public or protected, only private or default
        // we don't want to create new objects
        // this is not the enum concept

        // internally: public static final Week Monday = new Week();
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

        week.hello();
        System.out.println(Week.valueOf("Monday"));
//        for (Week day : Week.values()) {
//            System.out.println(day);
//        }
//
//        System.out.println(week.ordinal());

    }
}
