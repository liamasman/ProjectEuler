package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.TestCase;
import com.liamasman.projecteuler.framework.runner.Problem;
import com.liamasman.projecteuler.framework.runner.ProblemCollector;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Named.named;

public class ProblemsTest {

    @ParameterizedTest(name = "{0}: {1}")
    @ArgumentsSource(ProblemCaseArgumentsProvider.class)
    void problemTest(final Problem problem, final TestCase testCase) throws Exception {
        final var input = testCase.input();
        final var result = problem.runProblem(input);
        final var expectedResult = testCase.solution();
        assertEquals(expectedResult, result);
    }

    static class ProblemCaseArgumentsProvider implements org.junit.jupiter.params.provider.ArgumentsProvider {
        final ProblemCollector problemCollector = new ProblemCollector("com.liamasman.projecteuler.problems");

        @Override
        public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
            return problemCollector.getProblems()
                    .sorted(Comparator.comparingInt(Problem::getId))
                    .flatMap(this::getArgumentsForProblem);
        }

        private Stream<Arguments> getArgumentsForProblem(final com.liamasman.projecteuler.framework.runner.Problem problem) {
            return Arrays.stream(problem.getTestCases())
                    .map(testCase -> Arguments.of(
                            named(String.format("%04d - %s", problem.getId(), problem.getName()), problem),
                            named(Arrays.toString(testCase.input()), testCase)
                    ));
        }
    }
}
