package scala.tools.javac

import scala.tools.nsc.CompilerCommand
import scala.tools.nsc.Global

object Main {

  def main(args: Array[String]) {
    print("Initializing compiler.. ")
    val cmd = new CompilerCommand(args.toList, s => println(s))

    val global = new Global(cmd.settings)
    new global.Run
    import global._

    println("done.")

    val sourceFiles = cmd.files.filter(_.endsWith(".java")).map(global.getSourceFile)

    println(s" === parsing ${sourceFiles.size} files ===")

    val wallClock = timed {
      for (f <- sourceFiles) {
        val parser = new syntaxAnalyzer.JavaUnitParser(new CompilationUnit(f))

        parser.parse()
      }
    }

    println(" === parsing took %,d microseconds ===".format(wallClock / 1000))
  }

  def timed(body: => Unit): Long = {
    val start = System.nanoTime()
    body
    System.nanoTime - start
  }

}