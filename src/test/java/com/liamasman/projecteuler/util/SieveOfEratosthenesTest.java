package com.liamasman.projecteuler.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class SieveOfEratosthenesTest {
    @Test
    void iteratorTest() {
        final List<Long> expected = Arrays.asList(
                2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L
        );

        final SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        final List<Long> primes = StreamSupport.stream(sieve.spliterator(), false)
                .takeWhile(p -> p < 50L)
                .toList();

        assertEquals(expected, primes);
    }
}