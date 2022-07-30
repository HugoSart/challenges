package com.hsartori.challenges.commons.structures.graph;

import java.util.Objects;

public class Node implements Comparable<Node> {
    public int id;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
