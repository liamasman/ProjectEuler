package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;

import java.util.Arrays;

public class SampleProblem {

    @ProblemCase(input = {"29", "30", "31"})
    @TestCase(input = {"10", "100", "1000"}, solution = "1110")
    @Problem(id = -1)
    public long sampleProblem(final String[] input)
    {
        return Arrays.stream(input).map(Long::parseLong)
                .reduce(0L, Long::sum);
    }
}
