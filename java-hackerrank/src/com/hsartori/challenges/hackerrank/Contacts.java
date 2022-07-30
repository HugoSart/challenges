package com.hsartori.challenges.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Contacts {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<String>> queries = new ArrayList<>();
        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> result = contacts(queries);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        final TreeSet<String> db = new TreeSet<>();
        final List<Integer> results = new ArrayList<>();
        for (List<String> query : queries) {
            final String command = query.get(0);
            final String parameter = String.join(" ", query.subList(1, query.size()));
            if (command.equals("add")) {
                db.add(parameter);
            } else if (command.equals("find")) {
                results.add(countOccurrences(db, parameter));
            } else {
                throw new IllegalStateException("'" + command + "' is not a valid command");
            }
        }
        return results;
    }

    public static int countOccurrences(final TreeSet<String> db, final String s) {
        int count = 0;
        String current = db.ceiling(s);
        while (current != null) {
            if (current.startsWith(s)) {
                count++;
                current = db.higher(current);
            } else {
                break;
            }
        }
        return count;
    }

}
