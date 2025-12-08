package com.liamasman.projecteuler;

import com.liamasman.projecteuler.cli.CliParser;
import com.liamasman.projecteuler.framework.runner.Problem;

import java.util.Arrays;

public class Main {
    static void main(final String[] args) {

        final var runParameters = CliParser.parseInput(args);

        final var problem = runParameters.problem();
        switch (runParameters.runMode()) {
            case PROBLEM -> {
                runProblemCase(problem);
            }
            case TEST -> {
                runTestCases(problem);
            }
        }
    }

    private static void runTestCases(final Problem problem) {
        Arrays.stream(problem.getTestCases()).forEach(testcase -> {
            final var result = problem.runProblem(testcase.input());
            if (testcase.solution().equals(result)) {
                IO.println(Arrays.toString(testcase.input()) + ": " + result + " passed ✔");
            } else {
                IO.println(Arrays.toString(testcase.input()) + ": " + result + " failed ❌. Expected "
                        + testcase.solution());
            }
        });
    }

    private static void runProblemCase(final Problem problem) {
        final var result = problem.runProblem(problem.getProblemCase().input());
        IO.println(result);
    }

    private static void printUsage() {
        IO.println("./project-euler <problem-id>");
    }
}
