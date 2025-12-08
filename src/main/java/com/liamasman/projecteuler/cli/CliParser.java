package com.liamasman.projecteuler.cli;

import com.liamasman.projecteuler.framework.runner.Problem;
import com.liamasman.projecteuler.framework.runner.ProblemCollector;

import java.util.Optional;
import java.util.OptionalInt;

import static com.liamasman.projecteuler.framework.runner.ProblemCollector.PROBLEMS_PACKAGE;

public class CliParser {
    public static RunParameters parseInput(final String[] args)
    {
        RunMode runMode = RunMode.PROBLEM;
        OptionalInt problemId = OptionalInt.empty();
        try {
            for (int i = 0; i < args.length; i++) {
                if ("-t".equals(args[i]) || "--test".equals(args[i])) {
                    runMode = RunMode.TEST;
                } else if ("-p".equals(args[i]) || "--problem".equals(args[i])) {
                    problemId = OptionalInt.of(Integer.parseInt(args[++i]));
                } else if (args[i].startsWith("--problem=")) {
                    problemId = OptionalInt.of(Integer.parseInt(args[i].substring("--problem=".length())));
                }
                else if (i == args.length - 1 && !args[i].startsWith("-"))
                {
                    problemId = OptionalInt.of(Integer.parseInt(args[i]));
                }
            }
        }
        catch (final NumberFormatException e)
        {
            throw new IllegalArgumentException("Could not parse id", e);
        }

        if (problemId.isEmpty())
        {
            throw new IllegalArgumentException("Missing problem id");
        }

        final ProblemCollector problemCollector = new ProblemCollector(PROBLEMS_PACKAGE);
        final OptionalInt finalProblemId = problemId;
        final Optional<Problem> problem = problemCollector.getProblems()
                .filter(p -> p.getId() == finalProblemId.getAsInt())
                .findFirst();

        if (problem.isEmpty())
        {
            throw new IllegalArgumentException("Could not find problem with id: " + finalProblemId.getAsInt());
        }

        return new RunParameters(problem.get(), runMode);
    }
}
