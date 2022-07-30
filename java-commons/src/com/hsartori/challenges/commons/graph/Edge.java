package com.hsartori.challenges.commons.graph;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    public Node source;
    public Node target;
    public double weight;

    public Edge(Node source, Node target) {
        this(source, target, 0.0);
    }

    public Edge(Node source, Node target, double weight) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(edge.weight, weight) == 0 && source.equals(edge.source) && target.equals(edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, weight);
    }

    @Override
    public int compareTo(Edge o) {
        final int cmp = Double.compare(weight, o.weight);
        if (cmp == 0) {
            final int cmp1 = source.compareTo(o.source);
            return cmp1 == 0 ? target.compareTo(o.target) : cmp1;
        }
        return cmp;
    }

    @Override
    public String toString() {
        return source.id + " -> " + target.id;
    }
}
