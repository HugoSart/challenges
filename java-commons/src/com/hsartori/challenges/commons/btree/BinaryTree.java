package com.hsartori.challenges.commons.btree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class BinaryTree<T> {
    public BinaryNode<T> root;

    BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T value) {
        this.root = new BinaryNode<>(value);
    }

    public BinaryTree(Iterable<T> values) {
        values.forEach(this::add);
    }

    public BinaryTree(T ...values) {
        for (T value : values) {
            add(value);
        }
    }

    public int height() {
        int height = 0;
        final LinkedList<BinaryNode<T>> nodesInLevel = new LinkedList<>(Set.of(root));
        while (!nodesInLevel.isEmpty()) {
            height++;
            // System.out.println(nodesInLevel.stream().map(s -> s.value.toString()).collect(Collectors.joining(", ")));
            int count = nodesInLevel.size();
            while (count-- > 0) {
                final BinaryNode<T> curr = nodesInLevel.poll();
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
        final BinaryNode<T> node = new BinaryNode<>(key);
        if (root == null) {
            root = node;
            return;
        }
        BinaryNode<T> prev = null;
        BinaryNode<T> temp = root;
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

    static class BinaryNode<T> {
        T value;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T value) {
            this.value = value;
        }

        BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
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
            BinaryNode<?> that = (BinaryNode<?>) o;
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
