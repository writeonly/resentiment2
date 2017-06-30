package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.compilers.Interpreter
import io.github.writeonly.resentiment.teapot.parsers.BlockParserLLAsm
import io.github.writeonly.resentment.teapot.BlackSpec

class HelloWorld1 extends BlackSpec {
  val code =
"""
CH 'H' OUT
CH 'e' OUT
CH 'l' OUT OUT
CH 'o' OUT
"""
  val parser = new BlockParserLLAsm

  feature("Parser") {

    scenario("Apply one exclamation") {
      Given("converter FileJson2Yaml")
      val interpreter = new Interpreter

      When("should produce null when consume null")
      val parsed = parser(code)
      interpreter(parsed.get)

      Then("0 == result")
      assertResult("Hello") {
        interpreter.out.toString()
      }
    }

    ignore("Apply two exclamation") {

    }
  }

}
