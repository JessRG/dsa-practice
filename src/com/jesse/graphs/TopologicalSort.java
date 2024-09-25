package com.jesse.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class DirectedGraph {
    int vertices;
    LinkedList<Integer>[] adjList;

    // constructor
    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }
}

public class TopologicalSort {
    public static void main(String[] args) {
        int vertices = 7;
//        vertices = 4;
//        vertices = 3;
        int[][] edges = new int[][] {{6, 4},{6, 2},{5, 3},{5, 4},{3, 0},{3, 1},{3, 2},{4, 1}};
//        edges = new int[][] {{3, 2},{3, 0},{2, 0},{2, 1}};
//        edges = new int[][] {{0,1},{1,2},{2,0}};

        System.out.println(sort(vertices, edges));
    }

    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here

        // build graph
        DirectedGraph g = new DirectedGraph(vertices);

        // add edges
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        int[] inDegrees = new int[vertices];
        Queue<Integer> q = new LinkedList<>();

        // calculate in-degrees
        for (int v = 0; v < vertices; v++) {
            for (Integer neighbor : g.adjList[v]) {
                inDegrees[neighbor]++;
            }
        }

        // add vertices with no in-degrees to the queue
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            Integer v = q.poll();

            result.add(v);

            // iterate through all the neighbors of vertex v
            for (Integer neighbor : g.adjList[v]) {
                if (--inDegrees[neighbor] == 0) {
                    q.add(neighbor);
                }
            }

            count++;
        }

        if (count != vertices) {
            return new ArrayList<>();
        }

        return result;
    }
}
