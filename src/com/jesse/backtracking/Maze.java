package com.jesse.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3,3));
//        paths("",3,3);
//        System.out.println(pathsRet("", 3, 3));
//        System.out.println(pathsRetDiagonal("", 3, 3));

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathsWithRestrictions("", board, 0,0);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        // left-hand side (LHS)
        int left = count(r - 1, c);
        // right-hand side (RHS)
        int right = count(r, c - 1);

        return left + right;
    }

    static void paths(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            paths(p + "D", r - 1, c);
        }

        if (c > 1) {
            paths(p + "R", r, c - 1);
        }
    }

    static List<String> pathsRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(pathsRet(p + 'D', r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathsRet(p + 'R', r, c - 1));
        }

        return list;
    }

    static List<String> pathsRetDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1 && c > 1) {
            list.addAll(pathsRetDiagonal(p + 'D', r - 1, c - 1));
        }

        if (r > 1) {
            list.addAll(pathsRetDiagonal(p + 'V', r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathsRetDiagonal(p + 'H', r, c - 1));
        }

        return list;
    }

    static void pathsWithRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathsWithRestrictions(p + "D", maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            pathsWithRestrictions(p + "R", maze, r, c + 1);
        }
    }
}
