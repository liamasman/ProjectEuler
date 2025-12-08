package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;

import java.math.BigInteger;

public class P0006 {

    @Problem(id = 6)
    @ProblemCase(input = "100")
    @TestCase(input = "10", solution = "2640")
    public BigInteger sumSquareDifference(final String[] input) {
        final BigInteger limit = new BigInteger(input[0]);

        final BigInteger limitPlusOne = limit.add(BigInteger.ONE);

        final BigInteger sum = limit.multiply(limitPlusOne).divide(BigInteger.TWO);
        final BigInteger sumSquare = BigInteger.TWO
                .multiply(limit)
                .add(BigInteger.ONE)
                .multiply(limitPlusOne)
                .multiply(limit)
                .divide(BigInteger.valueOf(6L));

        return sum.multiply(sum).subtract(sumSquare);
    }
}
