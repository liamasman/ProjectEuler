package com.liamasman.projecteuler;

import com.liamasman.projecteuler.cli.CliParser;
import com.liamasman.projecteuler.cli.RunParameters;
import com.liamasman.projecteuler.framework.runner.Problem;

import java.util.Arrays;

public class Main {
    static void main(final String[] args) {

        final var runParameters = CliParser.parseInput(args);

        final var problem = runParameters.problem();
        switch (runParameters.runMode()) {
            case PROBLEM -> {
                runProblemCase(problem, runParameters);
            }
            case TEST -> {
                runTestCases(problem, runParameters);
            }
        }
    }

    private static void runTestCases(final Problem problem, final RunParameters runParameters) {
        Arrays.stream(problem.getTestCases()).forEach(testcase -> {
            final var result = problem.runProblem(testcase.input());
            if (testcase.solution().equals(result.solution())) {
                IO.println(Arrays.toString(testcase.input()) + ": " + result.solution() + " passed ✔" +
                        (runParameters.includeTimings() ? (" (" + result.microsTaken() + "µs)") : ""));
            } else {
                IO.println(Arrays.toString(testcase.input()) + ": " + result + " failed ❌. Expected "
                        + testcase.solution());
            }
        });
    }

    private static void runProblemCase(final Problem problem, final RunParameters runParameters) {
        final var result = problem.runProblem(problem.getProblemCase().input());
        IO.println(result.solution());
        if (runParameters.includeTimings()) {
            IO.println("(" + result.microsTaken() + "µs)");
        }
    }

    private static void printUsage() {
        IO.println("./project-euler <problem-id>");
    }
}
