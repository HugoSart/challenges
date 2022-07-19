package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import static com.hsartori.challenges.commons.math.MathUtils.isPrime;


/**
 * <strong>10001st prime</strong>
 * <br><br>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <br><br>
 * What is the 10 001st prime number?
 */
public final class Problem7 extends Problem {

    @Override
    protected Object solve() {
        int count = 1;
        int num = 3;
        while (true) {
            if (isPrime(num) && (++count == 10_001)) {
                return num;
            }
            num += 2;
        }
    }

}
