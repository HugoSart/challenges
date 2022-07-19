package com.hsartori.challenges.projecteuler;

import com.hsartori.challenges.projecteuler.utilities.Problem;

import static com.hsartori.challenges.commons.math.MathUtils.isPalindrome;

/**
 * <strong>	Largest palindrome product</strong>
 * <br><br>
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <br><br>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public final class Problem4 extends Problem {

    @Override
    protected Object solve() {
        int largest = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int m = i * j;
                if (isPalindrome(m) && m > largest) {
                    largest = m;
                    break;
                } else if (m < largest) {
                    break;
                }
            }
        }
        return largest;
    }

}
