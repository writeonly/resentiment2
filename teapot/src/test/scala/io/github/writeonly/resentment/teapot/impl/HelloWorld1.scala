package io.github.writeonly.resentment.teapot.impl

import io.github.writeonly.resentment.core.impl.UniCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.compilator.Compilator
import io.github.writeonly.resentment.corn.compilator.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.corn.compilator.generators.GeneratorImpl
import io.github.writeonly.resentment.teapot.BlackSpec

class HelloWorld1 extends BlackSpec {
  val code =
"""
CH 'H' OUT
CH 'e' OUT
CH 'l' OUT OUT
CH 'o' OUT
"""
  val expected = "Hello"
  val parser = new AnalyzerLLAsm

  feature("Parser") {

    ignore("HelloWorld1") {
      Given("interpreter")
      val io = StreamIO.byteArray("")
      val interpreter = new GeneratorImpl(new UniCoreFake(io))
      val parser = new AnalyzerLLAsm
      val compiler = new Compilator(parser, interpreter)

      When("parse and interprete code")
      val out = compiler.apply(code)

      Then("expected => " + expected )
      assertResult(expected) {
        out
      }
    }

    ignore("Apply two exclamation") {

    }
  }

}
