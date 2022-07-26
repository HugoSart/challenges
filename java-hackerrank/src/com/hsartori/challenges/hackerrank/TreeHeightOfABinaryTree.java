package com.hsartori.challenges.hackerrank;

import com.hsartori.challenges.commons.structures.tree.BinarySearchTree;

import java.util.Scanner;

public class TreeHeightOfABinaryTree {

    public static void main(String[] args) {
        final BinarySearchTree<Integer> tree = readEntry();
        final int height = tree.height();
        System.out.println(height);
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
