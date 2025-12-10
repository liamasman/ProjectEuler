package com.liamasman.projecteuler.cli;


import com.liamasman.projecteuler.framework.runner.Problem;

public record RunParameters(Problem problem,
                            RunMode runMode,
                            boolean includeTimings,
                            java.util.Optional<String> customInput) {
}
