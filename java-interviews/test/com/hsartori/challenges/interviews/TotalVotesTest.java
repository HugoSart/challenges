package com.hsartori.challenges.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalVotesTest {

    @Test
    void case0() {
        final int r = TotalVotes.getVoteCount("Seattle", 110);
        assertEquals(2116, r);
    }

}
