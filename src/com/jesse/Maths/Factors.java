package com.jesse.Maths;

import java.util.ArrayList;
import java.util.List;

public class Factors {
    public static void main(String[] args) {
//        factors(20);
//        factorsSqrt(20);
        factorsSqrtSort(20);
    }

    // O(n)
    private static void factors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // O(sqrt(n))
    private static void factorsSqrt(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }

            }
        }
    }

    // Both time and space will be O(sqrt(n))
    private static void factorsSqrtSort(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }

            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
