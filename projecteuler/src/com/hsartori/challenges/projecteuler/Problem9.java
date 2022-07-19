package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * <strong>Special Pythagorean triplet</strong>
 * <br><br>
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <br><br>
 * a2 + b2 = c2
 * <br><br>
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * <br><br>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public final class Problem9 extends Problem {

    @Override
    protected Object solve() {
        double target = 1000;
        for (double a = 0; a < target; a++) {
            for (double b = a + 1; b < target; b++) {
                double c = sqrt(pow(a, 2) + pow(b, 2));
                if (b == c) {
                    break;
                } else if (a + b + c == 1000) {
                    return (long) (a * b * c);
                }
            }
        }
        return null;
    }

}
