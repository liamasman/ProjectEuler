package com.liamasman.projecteuler.framework.runner;

import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class Problem {
    private final Method method;

    public Problem(final Method method) {
        this.method = method;
    }

    public int getId() {
        return method.getAnnotation(com.liamasman.projecteuler.framework.annotation.Problem.class)
                .id();
    }

    public String runProblem(final String[] input) {
        try {
            final Object instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
            return Objects.toString(method.invoke(instance, (Object) input));
        } catch (final NoSuchMethodException | InstantiationException |
                       IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public ProblemCase getProblemCase() {
        return method.getAnnotation(ProblemCase.class);
    }

    public TestCase[] getTestCases() {
        return method.getAnnotationsByType(TestCase.class);
    }
}
