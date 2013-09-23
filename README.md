run-javac
=========

A simple wrapper around the Scala compiler that invokes its **Java** parser and prints out the time it took to parse all files on the command line.

Usage
=====

```
$ scala -cp path/to//run-javac/bin/ scala.tools.javac.Main $CASSANDRASRC 
Initializing compiler.. done.
 === compiling 822 files ===
 === Compilation took 844,331 microseconds ===
```

Or, if the argument list is too long, you can read arguments from a `@file`:

```
$ scala -cp path/to/run-javac/bin/ scala.tools.javac.Main @jdksources
Initializing compiler.. done.
 === compiling 7436 files ===
 === Compilation took 2,543,626 microseconds ===
```
