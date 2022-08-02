package com.hsartori.challenges.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindTheRunningMedian {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = runningMedian(a);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Double> runningMedian(final List<Integer> values) {
        if (values == null || values.isEmpty())
            throw new IllegalArgumentException("Argument should be non empty array");
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Integer::compare);
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        final List<Double> medians = new ArrayList<>();
        for (final int value : values) {

            // Update heap
            if (medians.isEmpty()) {
                minHeap.add(value);
            } else {
                double currentMedian = medians.get(medians.size() - 1);
                if (value < currentMedian) {
                    maxHeap.add(value);
                } else {
                    minHeap.add(value);
                }
            }

            // Balance heaps
            if (abs(minHeap.size() - maxHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }

            // Calc median
            double median;
            if (minHeap.size() > maxHeap.size()) {
                median = (double) minHeap.peek();
            } else if (minHeap.size() < maxHeap.size()) {
                median = (double) maxHeap.peek();
            } else {
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
            medians.add(median);

        }
        return medians;
    }

}
