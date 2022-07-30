package com.hsartori.challenges.commons.math;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.Math.*;

public class MathUtils {

    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public static boolean isPalindrome(long n) {
        return String.valueOf(n).equals(new StringBuilder().append(n).reverse().toString());
    }

    public static boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;
        for (long i = 2; i <= floor(sqrt(n)); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static long factorial(long n) {
        if (n == 0) return 1;
        long r = n;
        for (long i = n - 1; i > 0 ; i--) {
            r *= i;
        }
        return r;
    }

    public static SortedSet<Long> divisors(long n) {
        if (n == 1) return new TreeSet<>(Set.of(1L));
        final TreeSet<Long> set = new TreeSet<>(Set.of(1L, n));
        for (long i = 2; i <= ceil((double) n / 2); i++) {
            if (n % i == 0)
                set.add(i);
        }
        return set;
    }

    public static SortedSet<Long> range(long min, long max) {
        final SortedSet<Long> set = new TreeSet<>();
        for (long i = min; i <= max; i++) {
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
