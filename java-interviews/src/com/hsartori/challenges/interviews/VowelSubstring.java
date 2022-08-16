package com.hsartori.challenges.interviews;

import java.util.HashSet;
import java.util.Set;

class VowelSubstring {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static int vowelsubstring(final String s) {
        int count = 0;
        for (int start = 0; start < s.length(); start++) {
            char[] chars = s.substring(start).toCharArray();
            Set<Character> consumedChars = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                final char c = chars[i];

                // End of substring
                if (!VOWELS.contains(c)) {
                    break;
                }

                // Consume char
                consumedChars.add(c);
                if (consumedChars.containsAll(VOWELS)) {
                    count++;
                }

            }

        }
        return count;
    }

}
