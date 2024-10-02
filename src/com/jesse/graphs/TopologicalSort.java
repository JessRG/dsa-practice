package com.jesse.graphs;

import java.util.*;

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
        System.out.println(sortWithHashMap(vertices, edges));
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

    public static List<Integer> sortWithHashMap(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return sortedOrder;
        }

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegrees = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list
        for (int i = 0; i < vertices; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // b. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1);
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its
        // children's in-degrees if a child's in-degree becomes zero, add it to sources queue
        while (!sources.isEmpty()) {
            Integer vertex = sources.poll();
            sortedOrder.add(vertex);

            List<Integer> children = graph.get(vertex);
            for (Integer child : children) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }
}
