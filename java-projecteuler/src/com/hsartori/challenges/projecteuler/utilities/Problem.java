package com.hsartori.challenges.projecteuler.utilities;

import org.junit.jupiter.api.Test;

public abstract class Problem {

    @Test
    public void run() {
        System.out.println(solve());
    }

    protected abstract Object solve();

}
