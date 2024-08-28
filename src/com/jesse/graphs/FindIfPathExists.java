package com.jesse.graphs;

import java.util.*;

public class FindIfPathExists {
    private static boolean[] visited; // To keep track of visited nodes
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int start = 0;
        int end = 2;

//        n = 3;
//        edges = new int[][] {{0,1}};
//        start = 0;
//        end = 2;

        n = 5;
        edges = new int[][] {{0,1},{1,2},{2,3},{3,4}};
        start = 0;
        end = 4;

        System.out.println(validPath(n, edges, start, end));
    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {
        // ToDo: Write Your Code Here.
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int currentVertex = q.poll();

            if (currentVertex == end) {
                return true;
            }

            for(int neighbor : adj.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[currentVertex] = true;
                    q.add(neighbor);
                }
            }
        }

        return false;
    }
}
