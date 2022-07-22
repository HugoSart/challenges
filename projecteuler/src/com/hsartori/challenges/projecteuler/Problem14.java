package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import java.util.*;

/**
 * <strong>Longest Collatz sequence</strong>
 * The following iterative sequence is defined for the set of positive integers:
 * <br><br>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <br><br>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <br><br>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <br><br>
 * Which starting number, under one million, produces the longest chain?
 * <br><br>
 * <strong>NOTE:</strong> Once the chain starts the terms are allowed to go above one million.
 */
public final class Problem14 extends Problem {

    @Override
    protected Object solve() {
        long input = 1_000_000;
        long max = 0, maxSize = 0;
        for (long i = input - 1; i >= 1 ; i -= 2) {
            final long length = collatzLength(i);
            if (length > maxSize) {
                maxSize = length;
                max = i;
            }
        }
        return max;
    }

    private Map<Long, Long> memo = new HashMap<>(Map.of(1L, 1L));

    private long collatzLength(long n) {

        // Base case
        if (memo.containsKey(n))
            return memo.get(n);

        // Compute
        final long val = n % 2 == 0
                ? (1 + collatzLength(n / 2))
                : (2 + collatzLength((3 * n + 1) / 2));
        memo.put(n, val);
        return val;

    }

}
