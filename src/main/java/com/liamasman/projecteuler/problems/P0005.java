package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;
import com.liamasman.projecteuler.util.SieveOfEratosthenes;

import java.util.stream.IntStream;

public class P0005 {
    @Problem(id = 5)
    @ProblemCase(input = "20")
    @TestCase(input = "10", solution = "2520")
    public int smallestMultiple(final String[] input) {
        final int maxNumber = Integer.parseInt(input[0]);

        final int[] numbers = IntStream.range(1, maxNumber + 1).toArray();

        int value = 1;

        final SieveOfEratosthenes sieve = new SieveOfEratosthenes();

        for (final Long aLong : sieve) {
            final int prime = aLong.intValue();
            if (prime > maxNumber) {
                break;
            }

            int count = 0;
            for (int j = 0; j < numbers.length; j++) {
                int primeCount = 0;
                while (numbers[j] % prime == 0) {
                    numbers[j] /= prime;
                    ++primeCount;
                }
                if (primeCount > count) {
                    count = primeCount;
                }
            }

            for (int k = 0; k < count; k++) {
                value *= prime;
            }
        }

        return value;
    }
}
