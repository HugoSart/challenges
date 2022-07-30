package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

/**
 * <strong>Multiples of 3 or 5</strong>
 * <br><br>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <br><br>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public final class Problem1 extends Problem {

    @Override
    public Object solve() {
        long sum = 0;
        for (int i = 0; i < 1_000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }

}
