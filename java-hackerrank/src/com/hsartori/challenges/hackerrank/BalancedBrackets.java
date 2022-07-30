package com.hsartori.challenges.hackerrank;

import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;

public class BalancedBrackets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        // BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();
                String result = isBalanced(s) ? "YES" : "NO";
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static boolean isOpening(final char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static boolean isPair(final char c1, final char c2) {
        return switch (c1) {
            case '{' -> c2 == '}';
            case '}' -> c2 == '{';
            case '[' -> c2 == ']';
            case ']' -> c2 == '[';
            case '(' -> c2 == ')';
            case ')' -> c2 == '(';
            default -> false;
        };
    }

    public static boolean isBalanced(final String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpening(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                final char h = stack.pop();
                if (!isPair(c, h)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}

