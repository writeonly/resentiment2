package io.github.writeonly.resentment.teapot.impl

import io.github.writeonly.resentment.core.impl.UniCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.compilator.Compilator
import io.github.writeonly.resentment.corn.compilator.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.corn.compilator.generators.GeneratorImpl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class UniCoreFakeSpec extends GrayScalarSpec {
  describe(classOf[UniCoreFake].toString) {
    val compiler = (io:StreamIO) => new Compilator(new AnalyzerLLAsm, new GeneratorImpl(new UniCoreFake(io)))

    it("CH -> OUT") {
      val code = "LDC 'A' OUT"
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("A")
    }

    it("Hello char") {
      val code =
        """
LDC 'H' OUT
LDC 'e' OUT
LDC 'l' OUT OUT
LDC 'o' OUT
"""
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("Hello")
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
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("Hello")
    }

  }
}
