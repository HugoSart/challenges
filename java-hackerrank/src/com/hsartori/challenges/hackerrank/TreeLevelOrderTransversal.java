package com.hsartori.challenges.hackerrank;

import com.hsartori.challenges.commons.structures.tree.BinarySearchTree;

import java.util.Scanner;

public class TreeLevelOrderTransversal {

    public static void main(String[] args) {
        final BinarySearchTree<Integer> tree = readEntry();
        tree.forEachTransversal(node -> System.out.print(node.value + " "));
    }

    private static BinarySearchTree<Integer> readEntry() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            tree.add(scanner.nextInt());
        }
        return tree;
    }

}
