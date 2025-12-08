# Project Euler

Implementations for solving [Project Euler](https://projecteuler.net) problems.

New problem implementations should be placed in `com.liamasman.projecteuler.problems`.

Problems must have:

* The `@Problem` annotation, specifying the problem id
* The `@ProblemCase` annotation, specifying the problem input as provided by Project Euler

A problem should also specify at least one `@TestCase`, typically given as the example
on Project Euler.

## How to build

This project is written using Java 25.

You must have an installation of a Java 25 JDK and set `JAVA_HOME` to point at it.

Run

```shell
./gradlew installDist
```

## How to run

Run the generated script:

```shell
build/install/project-euler/bin/project-euler <problem number>
```

## To Dos

* Run problem with new input from the command line
* Add optional timing to output