package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentiment.teapot.phases.generators.Interpreter
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

    scenario("HelloWorld1") {
      Given("interpreter")
      val interpreter = new Interpreter

      When("parse and interprete code")
      val parsed = parser(code)
      interpreter(parsed)

      Then("expected => " + expected )
      assertResult(expected) {
        interpreter.out.toString()
      }
    }

    ignore("Apply two exclamation") {

    }
  }

}
