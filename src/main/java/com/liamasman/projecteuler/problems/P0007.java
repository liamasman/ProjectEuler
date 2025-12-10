package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;
import com.liamasman.projecteuler.util.SieveOfEratosthenes;

public class P0007 {
    @Problem(id = 7)
    @ProblemCase(input = "10001")
    @TestCase(input = "6", solution = "13")
    public long tenThousandAndFirstPrime(final String[] input) {
        final var limit = Integer.parseInt(input[0]);

        final var sieve = new SieveOfEratosthenes();
        return sieve.stream()
                .skip(limit - 1)
                .findFirst()
                .get();
    }
}
