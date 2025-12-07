package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;

public class P0001 {

    @Problem(id = 1)
    @ProblemCase(input = {"1000"})
    @TestCase(input = {"10"}, solution = "23")
    public long multiplesOf3Or5(final String[] input) {
        final int limit = Integer.parseInt(input[0]);

        long sum = 0;
        for (int i = 0; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
