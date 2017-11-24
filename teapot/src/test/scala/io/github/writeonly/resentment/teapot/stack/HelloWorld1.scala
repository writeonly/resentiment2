package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.core.impl.CommonCoreUniFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.phrases.Phaser
import io.github.writeonly.resentment.corn.phrases.generators.GeneratorImpl
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
      val interpreter = new GeneratorImpl(new CommonCoreUniFake(io))
      val parser = new AnalyzerLLAsm
      val compiler = new Phaser(parser, interpreter)

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
