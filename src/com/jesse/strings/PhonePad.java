package com.jesse.strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        padCombos("", "89");
//        System.out.println(padCombosRet("", "93"));
    }

    static void padCombos(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // this will convert '2' into 2

        int range = digit == 7 || digit == 9 ? (digit - 1) * 3 + 1 : (digit - 1) * 3;

        for (int i = (digit - 2) * 3; i < range; i++) {
            char ch = digit > 7 && digit <= 9 ? (char) ('a' + i + 1) : (char) ('a' + i);
            padCombos(p + ch, up.substring(1));
        }
    }

    static List<String> padCombosRet(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '1'; // this will convert '2' into 2
        List<String> list = new ArrayList<>();
        int range = digit * 3;

        if (digit == 6 || digit == 8) {
            range = digit * 3 + 1;
        }

        for (int i = (digit - 1) * 3; i < range; i++) {
            char ch = digit > 6 && digit <= 8 ? (char) ('a' + i + 1) : (char) ('a' + i);
            list.addAll(padCombosRet(p + ch, up.substring(1)));
        }
        return list;
    }
}
