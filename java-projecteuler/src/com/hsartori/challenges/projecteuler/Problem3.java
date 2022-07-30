package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

/**
 * <strong>Largest prime factor</strong>
 * <br><br>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <br><br>
 * What is the largest prime factor of the number 600851475143 ?
 */
public final class Problem3 extends Problem {

    @Override
    protected Object solve() {
        long n = 600851475143L;
        long i = 2;
        while (n > 1) {
            if (n % i == 0) {
                n /= i;
            } else {

                // Optimization. 2 is the only even factor, so, we can increment by 2 each time
                if (i == 2) i++;
                else i += 2;

            }
        }
        return i;
    }

}
