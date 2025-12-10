package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;
import com.liamasman.projecteuler.util.SieveOfEratosthenes;

public class P0003 {

    @Problem(id = 3)
    @ProblemCase(input = "600851475143")
    @TestCase(input = "13195", solution = "29")
    public long largestPrimeFactor(final String[] input)
    {
        final long[] limit = new long[]{Long.parseLong(input[0])};
        final long[] largestPrime = new long[1];

        final SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        sieve.stream()
                .takeWhile(_p -> limit[0] > 1)
                .forEach(p -> {
                    while (limit[0] % p == 0)
                    {
                        limit[0] = limit[0] / p;
                        largestPrime[0] = p;
                    }
                });

        return largestPrime[0];
    }
}
