package com.hsartori.challenges.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwapNodesAlgo {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public void swap() {
            Node aux = left;
            left = right;
            right = aux;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private static Node createTree(final List<List<Integer>> indexes) {
        final Node root = new Node(1);
        final Queue<Node> queue = new LinkedList<>(List.of(root));
        int i = 0;
        while (!queue.isEmpty()) {
            final Node current = queue.poll();
            final List<Integer> values = indexes.get(i);

            // Add in correct side
            if (current.left == null && current.right == null) {
                if (values.get(0) != -1) {
                    current.left = new Node(values.get(0));
                }
                if (values.get(1) != -1) {
                    current.right = new Node(values.get(1));
                }
            }

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            i++;
        }
        return root;
    }

    private static List<Integer> inOrderValues(final Node node) {

        // Base case
        if (node.isLeaf()) {
            return List.of(node.value);
        }

        // Logic
        final List<Integer> values = new ArrayList<>();
        if (node.left != null) values.addAll(inOrderValues(node.left));
        values.add(node.value);
        if (node.right != null) values.addAll(inOrderValues(node.right));
        return values;

    }

    private static List<Integer> swap(final Node root, final int k) {
        final Queue<Node> queue = new LinkedList<>(List.of(root));
        int levelSize = queue.size();
        int depth = 1;
        while (!queue.isEmpty()) {
            final Node current = queue.poll();

            // Add in correct side
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            // Swap
            if (depth % k == 0) {
                current.swap();
            }

            // Calc depth
            if (--levelSize == 0) {
                levelSize = queue.size();
                depth++;
            }

        }
        return inOrderValues(root);
    }

    private static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        final List<List<Integer>> result = new ArrayList<>();

        // Init tree
        final Node root = createTree(indexes);

        // Operations
        for (Integer query : queries) {
            result.add(swap(root, query));
        }

        return result;

    }

}

