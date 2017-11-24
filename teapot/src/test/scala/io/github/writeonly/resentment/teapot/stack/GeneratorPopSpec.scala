package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.corn.core.CorePop
import io.github.writeonly.resentment.corn.phrases.Phaser
import io.github.writeonly.resentment.corn.phrases.generators.GeneratorPop
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class GeneratorPopSpec extends GrayScalarSpec {
  describe(classOf[GeneratorPop].toString) {

    val compiler = () => new Phaser(new AnalyzerLLAsm, new GeneratorPop(new CorePop))

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
      val i = c.backEnd.asInstanceOf[GeneratorPop]
      val e = i.e.asInstanceOf[CorePop]
      e.m should equal (Map(0 -> 'H'.toInt))
      e.b should equal (Map('H -> 0))
      e.p should equal (1)
      e.a should equal ('H'.toInt)
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
