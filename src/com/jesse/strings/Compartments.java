package com.jesse.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compartments {

    public static void main(String[] args) {
        String s = "*|*|*|";
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(1);
        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(6);

        System.out.println(numberOfItems(s, startIndices, endIndices));
    }
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        Stack<Integer> startBucket = new Stack<>();
        Stack<Integer> endBucket = new Stack<>();

        for (int i = startIndices.size() - 1; i >= 0; i--) {
            startBucket.push(startIndices.get(i) - 1);
        }

        for (int i = endIndices.size() - 1; i >= 0; i--) {
            endBucket.push(endIndices.get(i));
        }

        List<Integer> result = new ArrayList<>();
        int sum = 0;
        while (!startBucket.isEmpty() && !endBucket.isEmpty()) {
            int start = startBucket.pop();
            int end = endBucket.pop();

            String str = s.substring(start, end);
            int left = str.indexOf("|");
            int right = left + 1;
            while (right < str.length()) {
                if (str.charAt(right) != '|') {
                    right += 1;
                } else {
                    sum += right - left - 1;
                    left = right;
                    right += 1;
                }
            }
            result.add(sum);
        }

        return result;
    }
}
