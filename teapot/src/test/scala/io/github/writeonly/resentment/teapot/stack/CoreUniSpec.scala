package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.corn.core.{CorePop, CoreUni}
import io.github.writeonly.resentment.corn.phrases.Phaser
import io.github.writeonly.resentment.corn.phrases.generators.GeneratorImpl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class CoreUniSpec extends GrayScalarSpec {
  describe(classOf[CoreUni].toString) {
    val compiler = () => new Phaser(new AnalyzerLLAsm, new GeneratorImpl(new CoreUni))

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

  }
}
