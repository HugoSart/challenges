package com.hsartori.challenges.commons.structures.graph;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Graph {
    public Set<Node> nodes = new TreeSet<>();
    public Set<Edge> edges = new TreeSet<>();
    public boolean unidirectional = false;

    public Graph() {
        // empty
    }

    public Graph(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            addNode(new Node(i));
        }
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public Node getNode(int id) {
        return nodes.stream().filter(n -> n.id == id).findFirst().orElse(null);
    }

    public Set<Edge> getEdges(final Node node) {
        return edges.stream().filter(e -> !unidirectional
                ? (e.source.equals(node) || e.target.equals(node))
                : (e.source.equals(node))
        ).collect(Collectors.toCollection(TreeSet::new));
    }

}
