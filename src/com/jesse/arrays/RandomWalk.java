package com.jesse.arrays;

import java.util.Random;

public class RandomWalk {
    public static void main(String[] args) {
        int numSteps = 10; // Number of steps in the random walk
        int[] fibonacci = generateFibonacci(numSteps);

        // Initialize the starting position
        int x = 0;
        int y = 0;

        Random random = new Random();

        System.out.println("Random Walk (Fibonacci Steps):");
        for (int i = 0; i < numSteps; i++) {
            int step = fibonacci[i];
            int direction = random.nextInt(5); // 0: North, 1: South, 2: West, 3: East, 4: Up

            switch (direction) {
                case 0:
                    y += step; // North
                    break;
                case 1:
                    y -= step; // South
                    break;
                case 2:
                    x -= step; // West
                    break;
                case 3:
                    x += step; // East
                    break;
                case 4:
                    // Up (not changing x or y)
                    break;
            }

            System.out.printf("Step %d: (%d, %d)%n", i + 1, x, y);
        }
    }

    // Generate the first n Fibonacci numbers
    private static int[] generateFibonacci(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }
}
