package com.jesse.graphs;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] connected = {{1,1,0},{1,1,0},{0,0,1}};
//        connected = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
//        connected = new int[][] {{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}};

        System.out.print(findCircleNum(connected));
    }

    // Number of Providences
    public static int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        // ToDo: Write Your Code Here.
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                dfs(isConnected, visited, city);
                provinces ++;
            }
        }

        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city) {
        int[] province = isConnected[city];
        visited[city] = true;
        for (int neighbors = 0; neighbors < province.length; neighbors++) {
            if (province[neighbors] == 1 && !visited[neighbors]) {
                dfs(isConnected, visited, neighbors);
            }
        }
    }
}
