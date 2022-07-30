package com.hsartori.challenges.interviews;

import java.util.*;
import java.util.stream.Collectors;

import static com.hsartori.challenges.commons.math.MathUtils.isNumeric;

public class HierarchicalSorting {

    private static class Node implements Comparable<Node>, Iterable<Node> {
        public Node parent = null;
        public String tag = "root";
        public List<Double> values = new ArrayList<>();
        public SortedSet<Node> children = new TreeSet<>();

        public void add(final Node other) {
            children.stream().filter(n -> n.equals(other)).findFirst().ifPresentOrElse(
                    current -> {
                        for (Node child : other.children) {
                            current.add(child);
                        }
                    },
                    () -> {
                        other.parent = this;
                        children.add(other);
                        if (values.isEmpty()) {
                            values = new ArrayList<>(other.values);
                        } else {
                            for (int i = 0; i < other.values.size(); i++) {
                                values.set(i, values.get(i) + other.values.get(i));
                            }
                        }
                    }
            );
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        public List<Node> parents() {
            final List<Node> parents = new ArrayList<>();
            Node curr = parent;
            while (curr != null) {
                parents.add(curr);
                curr = curr.parent;
            }
            Collections.reverse(parents);
            return parents;
        }

        @Override
        public int compareTo(Node o) {
            if (equals(o)) {
                return 0;
            }
            return -values.get(0).compareTo(o.values.get(0));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(tag, node.tag);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tag);
        }

        @Override
        public String toString() {
            return "Node("
                    + "tag=" + tag + ", "
                    + "values=[" + values.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]"
                    + ")";
        }

        public static Node fromHierarchy(final String[] h) {
            Node node = null;
            Node root = null;
            for (String prop : h) {

                // Threat numeric value
                if (isNumeric(prop)) {
                    node.values.add(Double.parseDouble(prop));
                    continue;
                }

                // Threat property
                Node newNode = new Node();
                newNode.tag = prop;
                if (node == null) {
                    node = newNode;
                    root = node;
                } else {
                    node.add(newNode);
                    node = newNode;
                }

            }
            for (Node parent : node.parents()) {
                parent.values = node.values;
            }
            return root;
        }

        @Override
        public Iterator<Node> iterator() {
            return new NodeIterator(this);
        }

    }

    private static class NodeIterator implements Iterator<Node> {
        private final PriorityQueue<Node> queue = new PriorityQueue<>();

        private NodeIterator(Node root) {
            queue.add(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Node next() {
            final Node curr = queue.poll();
            queue.addAll(curr.children);
            return curr;
        }

    }

    public static void main(String[] args) {

        // Read input
        String[] header;
        boolean isFirst = true;
        final Scanner scanner = new Scanner(System.in);
        final Node tree = new Node();
        while (scanner.hasNext()) {
            final String[] row = scanner.nextLine().split("\\|");

            // Read header
            if (isFirst) {
                header = row;
                isFirst = false;
                continue;
            }

            // Skip totals
            if (Arrays.asList(row).contains("$total")) {
                continue;
            }

            // Read values
            final Node node = Node.fromHierarchy(row);
            tree.add(node);

        }

        // Print
        for (Node child : tree) {
            if (child.isLeaf()) {

                // Print
                final StringBuilder builder = new StringBuilder();
                final List<Node> parents = child.parents();
                builder.append(parents.stream().map(n -> n.tag).collect(Collectors.joining("|")));
                builder.append("|").append(child.tag);
                for (Double value : child.values)
                    builder.append("|").append(value);
                System.out.println(builder);

            }
        }

    }

}
