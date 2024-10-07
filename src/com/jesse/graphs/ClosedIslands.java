package com.jesse.graphs;

public class ClosedIslands {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,1,0,0,0},
                {0,1,0,0,0},
                {0,0,1,1,0},
                {0,1,1,0,0},
                {0,0,0,0,0}
        };
        System.out.println(countClosedIslands(matrix));
    }

    public static int countClosedIslands(int[][] matrix) {
        int countClosedIslands = 0;
        // TODO: Write your code here

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1 && !visited[r][c]) {
                    if (isClosedIsland(matrix, visited, r, c)) {
                        countClosedIslands += 1;
                    }
                }
            }
        }

        return countClosedIslands;
    }

    private static boolean isClosedIsland(int[][] matrix, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return false;
        }
        if (matrix[row][col] == 0 || visited[row][col]) {
            return true;
        }
        visited[row][col] = true;
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean isClosed = true;
        for (int[] neighbor : neighbors) {
            int r = row + neighbor[0];
            int c = col + neighbor[1];
            isClosed &= isClosedIsland(matrix, visited, r, c);
        }
        return isClosed;
    }
}
