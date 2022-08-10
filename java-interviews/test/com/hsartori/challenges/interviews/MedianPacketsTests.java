package com.hsartori.challenges.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianPacketsTests {

    @Test
    void case0() {
        final var result = new MedianPackets().calc(2, 1, 2, 3, 4, 5);
        assertEquals(7.5, result);
    }

    @Test
    void case1() {
        final var result = new MedianPackets().calc(3, 1, 2, 3, 2, 1, 5);
        assertEquals(9.5, result);
    }

}
