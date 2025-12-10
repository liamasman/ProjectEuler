package com.liamasman.projecteuler.util;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SieveOfEratosthenes implements Iterable<Long>{
    private final List<Long> primes;

    public SieveOfEratosthenes() {
        primes = new ArrayList<>();
    }

    @Override
    @Nonnull
    public Iterator<Long> iterator() {
        return new Iterator<>() {
            long last = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Long next() {
                if (last == 0) {
                    last = 2L;
                } else if (last == 2L) {
                    last = 3L;
                } else {
                    whileLoop:
                    while (true) {
                        last += 2;
                        for (long prime : primes) {
                            if (prime * prime > last) {
                                break whileLoop;
                            }
                            if (last % prime == 0) {
                                break;
                            }
                        }
                    }
                }

                primes.add(last);
                return last;
            }
        };
    }

    @Override
    public Spliterator<Long> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED | Spliterator.NONNULL | Spliterator.IMMUTABLE);
    }

    public Stream<Long> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
