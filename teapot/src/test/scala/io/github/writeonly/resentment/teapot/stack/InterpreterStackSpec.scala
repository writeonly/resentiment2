package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.glue.Phaser
import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentiment.teapot.phases.generators.InterpreterStack
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class InterpreterStackSpec extends GrayScalarSpec {
  describe(classOf[InterpreterStack].toString) {
    val compiler = () => new Phaser(new AnalyzerLLAsm, new InterpreterStack)

    it("CH -> OUT") {
      val code = "LDC 'A' OUT"
      compiler()(code) should equal ("A")
    }

    it("Hello char") {
      val code =
        """
LDC 'H' OUT
LDC 'e' OUT
LDC 'l' OUT OUT
LDC 'o' OUT
"""
      compiler()(code) should equal ("Hello")
    }

    it("H variable") {
      val code =
        """
LDC 'H' VAR 'H
LDV 'H OUT
"""
//      compiler().frondEnd(code) should equal ("H")
      val c = compiler()
      c(code)
      val i = c.backEnd.asInstanceOf[InterpreterStack]
      i.m should equal (Map(0 -> 'H'.toInt))
      i.b should equal (Map('H -> 0))
      i.p should equal (1)
      i.a should equal ('H'.toInt)
      compiler()(code) should equal ("H")
    }

    it("Hello variable") {
      val code =
        """
LDC 'H' VAR 'H
LDC 'e' VAR 'e
LDC 'l' VAR 'l
LDC 'o' VAR 'o

LDV 'H OUT
LDV 'e OUT
LDV 'l OUT OUT
LDV 'o OUT
"""
      compiler()(code) should equal ("Hello")
    }

    ignore("Hello string") {
      val code =
        """
LDS "Hello" VAR 'H

LDV 'H OUT
"""
      compiler()(code) should equal ("H")
    }

  }
}
