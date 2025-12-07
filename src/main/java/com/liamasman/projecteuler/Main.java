package com.liamasman.projecteuler;

import com.liamasman.projecteuler.framework.runner.ProblemCollector;

public class Main {
    static void main(final String[] args) {
        if (args.length < 1) {
            printUsage();
            return;
        }

        final int projectId;
        try {
            projectId = Integer.parseInt(args[0]);
        } catch (final NumberFormatException e)
        {
            IO.println("Invalid id: " + args[0]);
            printUsage();
            return;
        }

        final ProblemCollector problemCollector = new ProblemCollector("com.liamasman.projecteuler.problems");
        final var foundProblems = problemCollector.getProblems()
                .filter(p -> p.getId() == projectId)
                .toList();

        if (foundProblems.isEmpty())
        {
            IO.println("Found no problems with id: " + projectId);
            return;
        }
        if (foundProblems.size() > 1)
        {
            IO.println("Found more than one problem with id: " + projectId);
            return;
        }

        final var problem = foundProblems.getFirst();
        final var problemCase = problem.getProblemCase();
        final var result = problem.runProblem(problemCase.input());

        IO.println(result);
    }

    private static void printUsage()
    {
        IO.println("./project-euler <problem-id>");
    }
}
