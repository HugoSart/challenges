package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import java.util.SortedSet;

import static com.hsartori.challenges.commons.math.MathUtils.multiply;
import static com.hsartori.challenges.commons.math.MathUtils.range;

/**
 * <strong>Smallest multiple</strong>
 * <br><br>
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <br><br>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public final class Problem5 extends Problem {

    @Override
    protected Object solve() {
        final SortedSet<Long> range = range(11, 20);
        final double base = multiply(range);
        for (long i = range.last(); i <= base; i += range.last()) {

            // Check if is divisible by all
            boolean isCandidate = true;
            for (double j = 11; j <= 20; j++) {
                if (i % j != 0) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate) {
                return i;
            }

        }

        return null;
    }



}
