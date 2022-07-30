package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import static com.hsartori.challenges.commons.math.MathUtils.factorial;

/**
 * <strong>Lattice paths</strong>
 * <br><br>
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * <br><br>
 * <img src="https://projecteuler.net/project/images/p015.png">
 * <br><br>
 * How many such routes are there through a 20×20 grid?
 */
public final class Problem15 extends Problem {

    @Override
    protected Object solve() {
        long n = 20, m = 20;
        return factorial(n + m) / (factorial(n) * factorial(m));
    }

}
