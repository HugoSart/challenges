package com.hsartori.challenges.commons.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public final class GraphVisualizer {

    public static void printAllPathsFromTo(final Graph graph, final Node source, final Node target) {
        final Set<Node> visited = new HashSet();
        final PriorityQueue<Node> toVisit = new PriorityQueue<>();
        toVisit.add(source);
        while (!toVisit.isEmpty()) {
            final Node node = toVisit.poll();
            visited.add(node);
            if (!visited.contains(node)) {
                for (final Edge edge : graph.getEdges(node)) {
                    final Node other = edge.source.equals(node) ? edge.target : edge.source;
                    toVisit.add(other);
                }
            }
        }
    }

}
