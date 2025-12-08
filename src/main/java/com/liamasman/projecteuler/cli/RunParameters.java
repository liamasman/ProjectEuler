package com.liamasman.projecteuler.cli;


import com.liamasman.projecteuler.framework.runner.Problem;

import java.util.Optional;

public record RunParameters(Problem problem, RunMode runMode) {
}
