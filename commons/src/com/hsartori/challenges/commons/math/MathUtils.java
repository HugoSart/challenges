package com.hsartori.challenges.commons.math;

import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

public class MathUtils {

    public static boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;
        for (long i = 2; i <= floor(sqrt(n)); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(long n) {
        return String.valueOf(n).equals(new StringBuilder().append(n).reverse().toString());
    }

    public static SortedSet<Integer> range(int min, int max) {
        final SortedSet<Integer> set = new TreeSet<>();
        for (int i = min; i <= max; i++) {
            set.add(i);
        }
        return set;
    }

    public static double multiply(final Iterable<? extends Number> it) {
        double result = 1;
        for (final Number number : it) {
            result *= number.doubleValue();
        }
        return result;
    }

}
