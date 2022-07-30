package com.hsartori.challenges.hackerrank;

import com.hsartori.challenges.commons.structures.graph.Edge;
import com.hsartori.challenges.commons.structures.graph.Graph;
import com.hsartori.challenges.commons.structures.graph.Node;

import java.util.*;

public class CTCIBfsShortestReach {

    public static void main(String[] args) {
        final List<Entry> entries = readEntries();
        for (final Entry entry : entries) {
            final Graph graph = entry.graph;
            final Node s = entry.start;
            final Map<Node, Double> weights = new HashMap<>();

            // Run Dijkstra
            final PriorityQueue<Node> toVisit = new PriorityQueue<>();
            final Set<Node> visited = new HashSet<>();
            toVisit.add(s);

            // Iterate
            while (!toVisit.isEmpty()) {
                final Node node = toVisit.poll();
                if (!visited.contains(node)) {
                    visited.add(node);
                    final Set<Edge> edges = graph.getEdges(node);
                    for (final Edge e : edges) {
                        final Node other = e.source.equals(node) ? e.target : e.source;
                        toVisit.add(other);
                        final Double currentWeight = weights.getOrDefault(node, 0.0);
                        final Double currentTargetWeight = weights.getOrDefault(other, Double.POSITIVE_INFINITY);
                        final Double newWeight = currentWeight + e.weight;
                        if (newWeight < currentTargetWeight) {
                            weights.put(other, newWeight);
                        }
                    }
                }
            }

            // Output
            for (Node node : graph.nodes) {
                if (!node.equals(s)) {
                    double weight = weights.getOrDefault(node, -1.0);
                    System.out.print("" + (int) weight + " ");
                }
            }
            System.out.println();

        }
    }

    private static List<Entry> readEntries() {
        final List<Entry> entries = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);
        final int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            final int n = scanner.nextInt();
            final int m = scanner.nextInt();
            final Graph graph = new Graph(n);
            for (int j = 0; j < m; j++) {
                final int u = scanner.nextInt() - 1;
                final int v = scanner.nextInt() - 1;
                final Edge e = new Edge(graph.getNode(u), graph.getNode(v), 6);
                graph.addEdge(e);
            }
            final int s = scanner.nextInt() - 1;
            entries.add(new Entry(graph, graph.getNode(s)));
        }
        return entries;
    }

    private static class Entry {
        public Graph graph;
        public Node start;

        public Entry(Graph graph, Node start) {
            this.graph = graph;
            this.start = start;
        }
    }

}
