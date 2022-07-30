package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import static com.hsartori.challenges.commons.math.MathUtils.isPrime;

/**
 * <strong>Summation of primes</strong>
 * <br><br>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <br><br>
 * Find the sum of all the primes below two million.
 */
public final class Problem10 extends Problem {

    @Override
    protected Object solve() {
        double target = 2_000_000;
        double sum = 2;
        for (int i = 3; i < target; i += 2) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return (long) sum;
    }

}
