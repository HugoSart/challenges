package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import static java.lang.Math.pow;

/**
 * <strong>Sum square difference</strong>
 * <br><br>
 * The sum of the squares of the first ten natural numbers is,
 * <br><br>
 * 1² + 2² + ... + 10² = 385
 * <br><br>
 * The square of the sum of the first ten natural numbers is,
 * <br><br>
 * (1 + 2 + ... + 10)² = 55² = 3025
 * <br><br>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
 * <br><br>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public final class Problem6 extends Problem {

    @Override
    protected Object solve() {
        long sum = 0L;
        long squareSum = 0L;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            squareSum += pow(i, 2);
        }
        return (long) pow(sum, 2) - squareSum;
    }

}
