package com.hsartori.challenges.hackerrank;

import com.hsartori.challenges.commons.btree.BinaryTree;

import java.util.Scanner;

public class TreeHeightOfABinaryTree {

    public static void main(String[] args) {
        final BinaryTree<Integer> tree = readEntry();
        final int height = tree.height();
        System.out.println(height);
    }

    private static BinaryTree<Integer> readEntry() {
        final BinaryTree<Integer> tree = new BinaryTree<>();
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            tree.add(scanner.nextInt());
        }
        return tree;
    }

}
