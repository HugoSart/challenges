package com.hsartori.challenges.leetcode;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.max;


/**
 * <strong>2272. Substring With Largest Variance</strong>
 * <br><br>
 * The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.
 * <br><br>
 * Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.
 * <br><br>
 * A substring is a contiguous sequence of characters within a string.
 * <br><br>
 * Example 1:
 * <br>
 * <br>Input: s = "aababbb"
 * <br>Output: 3
 * <br>Explanation:
 * <br>All possible variances along with their respective substrings are listed below:
 * <br>- Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
 * <br>- Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
 * <br>- Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
 * <br>- Variance 3 for substring "babbb".
 * <br>Since the largest possible variance is 3, we return it.
 * <br><br>
 * Example 2:
 * <br>
 * <br>Input: s = "abcde"
 * <br>Output: 0
 * <br>Explanation:
 * <br>No letter occurs more than once in s, so the variance of every substring is 0.
 */
public class SubstringWithLargestVariance {

    // Algo state
    private final Map<Character, Long> frequencies = new HashMap<>();
    private long maxDeviation = 0;
    private long maxFreq = 0;
    private long minFreq = 0;

    // Properties
    private final String input;

    private SubstringWithLargestVariance(final String input) {
        this.input = input;
    }

    public static long variance(final String str) {
        return new SubstringWithLargestVariance(str).variance();
    }

    private void updateDeviation() {
        maxDeviation = max(maxDeviation, abs(maxFreq - minFreq));
    }

    private void increment(char c) {
        frequencies.compute(c, (k, v) -> v == null ? 1 : v + 1);
        updateDeviation();
    }

    private void decrement(char c) {
        if (frequencies.compute(c, (k, v) -> v == null ? -1 : v - 1) == 0)
            frequencies.remove(c);
        updateDeviation();
    }

    private long variance() {

        // Init variables
        int size = input.length();
        char[] chars = input.toCharArray();

        // Iterator
        int leftBound = 0;
        int rightBound = size - 1;
        while (leftBound <= rightBound) {

            // Expand right for even cases
            if (leftBound % 2 == 0) {
                for (int index = leftBound; index <= rightBound; index++) {
                    increment(chars[index]);
                }
            }

            // Come back left for odd cases
            else {
                for (int index = rightBound; index > leftBound; index--) {
                    decrement(chars[index]);
                }
            }

            // Prepare next iteration with the sub array without the leftest element
            decrement(chars[leftBound]);
            leftBound++;

        }

        return maxDeviation;

    }

}
