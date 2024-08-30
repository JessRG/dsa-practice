package com.jesse.graphs;

public class Islands {
    public static void main(String[] args) {
        Islands islands = new Islands();
//        [[1, 1, 1, 0, 0], [0, 1, 0, 0, 1], [0, 0, 1, 1, 0], [0, 0, 1, 0, 0], [0, 0, 1, 0, 0]]
//[[0, 1, 1, 1, 0],[0, 0, 0, 1, 1],[0, 1, 1, 1, 0],[0, 1, 1, 0, 0],[0, 0, 0, 0, 0]]
//[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
        int[][] matrix = new int[][] {{1, 1, 1, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 1, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}};
        matrix = new int[][] {{0, 1, 1, 1, 0},{0, 0, 0, 1, 1},{0, 1, 1, 1, 0},{0, 1, 1, 0, 0},{0, 0, 0, 0, 0}};
        matrix = new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(islands.countIslands(matrix));
    }

//    public int countIslands(int[][] matrix) {
//        int totalIslands = 0;
//        // TODO: Write your code here
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (!visited[i][j]) {
//                    totalIslands += findIslands(visited, matrix, i, j);
//                }
//            }
//        }
//        return totalIslands;
//    }
//
//    private int findIslands(boolean[][] visited, int[][] matrix, int r, int c) {
//        visited[r][c] = true;
//        if (matrix[r][c] != 1) {
//            return 0;
//        }
//        int[][] neighbors = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//        for (int[] neighbor : neighbors) {
//            int x = r + neighbor[0];
//            int y = c + neighbor[1];
//            if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1) {
//                continue;
//            }
//            if (matrix[x][y] == 1 && !visited[x][y]) {
//                visited[x][y] = true;
//                findIslands(visited, matrix, x, y);
//            } else {
//                visited[x][y] = true;
//            }
//        }
//        return 1;
//    }

    // Alternative Solution
    public int countIslands(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) { // only if the cell is a land
                    // we have found an island
                    totalIslands++;
                    visitIslandDFS(matrix, i, j);
                }
            }
        }
        return totalIslands;
    }

    private static void visitIslandDFS(int[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return; // return, if it is not a valid cell
        if (matrix[x][y] == 0)
            return; // return, if it is a water cell

        matrix[x][y] = 0; // mark the cell visited by making it a water cell

        // recursively visit all neighboring cells (horizontally & vertically)
        visitIslandDFS(matrix, x + 1, y); // lower cell
        visitIslandDFS(matrix, x - 1, y); // upper cell
        visitIslandDFS(matrix, x, y + 1); // right cell
        visitIslandDFS(matrix, x, y - 1); // left cell
    }
}
