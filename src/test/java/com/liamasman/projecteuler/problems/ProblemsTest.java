package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemsTest {

    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(ProblemCaseArgumentsProvider.class)
    void problemTest(final int id, final Method method, final String[] input, final String expectedResult) throws Exception {
        final Class<?> declaringClass = method.getDeclaringClass();
        final Object problem = declaringClass.getDeclaredConstructor().newInstance();
        Object result = method.invoke(problem, (Object) input);
        assertEquals(expectedResult, result.toString());
    }

    static class ProblemCaseArgumentsProvider implements org.junit.jupiter.params.provider.ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
            return getProblemMethods().flatMap(this::getArgumentsForMethod);
        }

        private Stream<Method> getProblemMethods() {
            final String problemsPackage = "com.liamasman.projecteuler.problems";
            final ConfigurationBuilder config = new ConfigurationBuilder()
                    .forPackage(problemsPackage,ProblemsTest.class.getClassLoader())
                    .setScanners(Scanners.MethodsAnnotated);
            final Reflections reflections = new Reflections(config);
            return reflections.getMethodsAnnotatedWith(Problem.class).stream();
        }

        private Stream<Arguments> getArgumentsForMethod(final Method method)
        {
            final Problem problem = method.getAnnotation(Problem.class);
            return Arrays.stream(method.getAnnotationsByType(TestCase.class))
                    .map(testCase -> Arguments.of(
                            problem.id(), method, testCase.input(), testCase.solution()
                    ));
        }
    }
}
