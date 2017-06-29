package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.parsers.BlockParserLLAsm
import io.github.writeonly.resentment.teapot.BlackSpec

class HelloWorld1 extends BlackSpec {
  val code =
"""
LD 'H' OUT
LD 'e' OUT
LD 'l' OUT OUT
LD 'o' OUT
"""
  val parser = new BlockParserLLAsm()

  feature("Parser") {

    scenario("Apply one exclamation") {
      Given("converter FileJson2Yaml")

      When("should produce null when consume null")

      Then("0 == result")

    }

    ignore("Apply two exclamation") {

    }
  }

}
