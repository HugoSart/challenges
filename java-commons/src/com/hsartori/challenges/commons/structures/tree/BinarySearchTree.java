package com.hsartori.challenges.commons.structures.tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<T> {
    public Node<T> root;

    BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(T value) {
        this.root = new Node<>(value);
    }

    public BinarySearchTree(Iterable<T> values) {
        values.forEach(this::add);
    }

    public BinarySearchTree(T ...values) {
        for (T value : values) {
            add(value);
        }
    }

    public int height() {
        int height = 0;
        final LinkedList<Node<T>> nodesInLevel = new LinkedList<>(Set.of(root));
        while (!nodesInLevel.isEmpty()) {
            height++;
            // System.out.println(nodesInLevel.stream().map(s -> s.value.toString()).collect(Collectors.joining(", ")));
            int count = nodesInLevel.size();
            while (count-- > 0) {
                final Node<T> curr = nodesInLevel.poll();
                if (curr.left != null) {
                    nodesInLevel.add(curr.left);
                }
                if (curr.right != null) {
                    nodesInLevel.add(curr.right);
                }
            }
        }
        return height - 1;
    }

    public void add(final T key) {
        final Node<T> node = new Node<>(key);
        if (root == null) {
            root = node;
            return;
        }
        Node<T> prev = null;
        Node<T> temp = root;
        while (temp != null) {
            if (temp.value.hashCode() > key.hashCode()) {
                prev = temp;
                temp = temp.left;
            } else if (temp.value.hashCode() < key.hashCode()) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.value.hashCode() > key.hashCode()) {
            prev.left = node;
        } else {
            prev.right = node;
        }
    }

    public void forEachTransversal(final Consumer<Node<T>> consumer) {
        final Queue<Node<T>> queue = new LinkedList<>(List.of(root));
        while (!queue.isEmpty()) {
            final Node<T> curr = queue.poll();
            consumer.accept(curr);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> that = (Node<?>) o;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

    }

}
