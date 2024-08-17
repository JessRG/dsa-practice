package com.jesse.strings;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
//        dice("", 4);
        System.out.println(diceRet("", 4));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static void dieFace(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static List<String> diceRet(String p, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p + i, target - i));
        }

        return list;
    }

    static List<String> dieFaceRet(String p, int target, int face) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(dieFaceRet(p + i, target - i, face));
        }

        return list;
    }
}
