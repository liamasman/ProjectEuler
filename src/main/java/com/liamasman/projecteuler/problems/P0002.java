package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;

public class P0002 {
    @Problem(id = 2)
    @ProblemCase(input = "4000000")
    @TestCase(input = "34", solution = "44")
    public long evenFibonacciNumbers(final String[] input) {
        final int limit = Integer.parseInt(input[0]);

        long sum = 0;
        long a = 1;
        long b = 2;

        while (a <= limit) {
            if (a % 2 == 0) {
                sum += a;
            }
            long next = a + b;
            a = b;
            b = next;
        }
        return sum;
    }

}
