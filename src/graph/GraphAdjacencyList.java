package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adj;

    public GraphAdjacencyList() {
        adj = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adj.computeIfAbsent(vertex, k -> new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        adj.computeIfAbsent(src, k -> new ArrayList<>())
                .add(dest);
        adj.computeIfAbsent(dest, k -> new ArrayList<>())
                .add(src);
    }

    public void printGraph() {
        for (int vertex : adj.keySet()) {
            System.out.println(vertex + " --> ");
            for (int neighbor : adj.get(vertex)) {
                System.out.printf("%d ", neighbor);
            }
            System.out.println();
        }
    }

    public class Main {
        public static void main(String[] args) {
        }
    }
}
