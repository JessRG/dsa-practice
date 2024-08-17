package com.jesse.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
            { 5,3,0,0,7,0,0,0,0 },
            { 6,0,0,1,9,5,0,0,0 },
            { 0,9,8,0,0,0,0,6,0 },
            { 8,0,0,0,6,0,0,0,3 },
            { 4,0,0,8,0,3,0,0,1 },
            { 7,0,0,0,2,0,0,0,6 },
            { 0,6,0,0,0,0,2,8,0 },
            { 0,0,0,4,1,9,0,0,5 },
            { 0,0,0,0,8,0,0,7,9 }
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        // This is how we are replacing the r, c from the arguments
        boolean emptyLeft = true;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) {
                    row = r;
                    col = c;
                    emptyLeft = false;
                    break;
                }
            }
            // If you found some empty element in row, then break
            if (emptyLeft == false) {
                break;
            }
        }

        if (emptyLeft == true) {
            // sudoku solved
            return true;
        }

        // backtracking
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board) == true) {
                    // found the answer
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // check columns
        for (int[] nums : board) {
            if (nums[col] == num) {
                return false;
            }
        }

        // check square matrix (3*3 box)
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
