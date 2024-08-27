package com.jesse.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return;
        }
        adjacencyList.remove(vertex);
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighbors.removeIf(v -> v == vertex);
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).removeIf(v -> v == vertex2);
        adjacencyList.get(vertex2).removeIf(v -> v == vertex1);
    }

    public List<Integer> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public List<Pair<Integer, Integer>> getEdges() {
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex1 = entry.getKey();
            for (int neighbor : entry.getValue()) {
                int vertex2 = neighbor;
                if (vertex1 < vertex2) {
                    edges.add(new Pair<>(vertex1, vertex2));
                }
            }
        }
        return edges;
    }

    public List<Integer> getNeighbors(int vertex) {
        return new ArrayList<>(adjacencyList.getOrDefault(vertex, new ArrayList<>()));
    }

    public boolean isAdjacent(int vertex1, int vertex2) {
        List<Integer> neighbors = adjacencyList.getOrDefault(vertex1, new ArrayList<>());
        return neighbors.contains(vertex2);
    }

    public int getVertexCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count / 2;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        System.out.print("Vertices: ");
        for (int vertex : graph.getVertices()) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getFirst() + ", " + edge.getSecond() + ") ");
        }
        System.out.println();

        System.out.print("Neighbors of vertex 1: ");
        for (int neighbor : graph.getNeighbors(1)) {
            System.out.print(neighbor + " ");
        }
        System.out.println();

        System.out.println("Is vertex 1 adjacent to vertex 2? " + graph.isAdjacent(1, 2));

        graph.removeEdge(1, 2);
        graph.removeVertex(3);

        System.out.println("After removing some edges and vertices:");

        System.out.print("Vertices: ");
        for (int vertex : graph.getVertices()) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getFirst() + ", " + edge.getSecond() + ") ");
        }
        System.out.println();
    }
}
