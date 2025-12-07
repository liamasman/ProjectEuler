package com.liamasman.projecteuler.framework.runner;

import com.liamasman.projecteuler.framework.annotation.Problem;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Stream;

public class ProblemCollector {
    private final String problemsPackage;

    public ProblemCollector(final String problemsPackage) {
        this.problemsPackage = problemsPackage;
    }

    public Stream<com.liamasman.projecteuler.framework.runner.Problem> getProblems() {
        final ConfigurationBuilder config = new ConfigurationBuilder()
                .forPackage(problemsPackage, ProblemCollector.class.getClassLoader())
                .setScanners(Scanners.MethodsAnnotated);
        final Reflections reflections = new Reflections(config);
        final Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(Problem.class);
        return methodsAnnotatedWith.stream()
                .map(com.liamasman.projecteuler.framework.runner.Problem::new);
    }
}
