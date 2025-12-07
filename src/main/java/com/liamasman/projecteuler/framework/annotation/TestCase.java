package com.liamasman.projecteuler.framework.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(TestCases.class)
public @interface TestCase {
    String[] input();

    String solution();
}
