package io.github.writeonly.resentment.teapot.impl

import java.io.ByteArrayOutputStream

import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.core.impl.CommonCorePopFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.phrases.Phaser
import io.github.writeonly.resentment.corn.phrases.generators.GeneratorImpl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class CommonCorePopFakeSpec extends GrayScalarSpec {
  describe(classOf[CommonCorePopFake].toString) {
    val compiler = (io: StreamIO) => new Phaser(new AnalyzerLLAsm, new GeneratorImpl(new CommonCorePopFake(io)))

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

    it("H variable") {
      val code =
        """
LDC 'H' VAR 'H
LDV 'H OUT
"""
//      compiler().frondEnd(code) should equal ("H")
      val io = StreamIO.byteArray("")
      val c = compiler(io)
      c(code)
      val i = c.backEnd.asInstanceOf[GeneratorImpl]
      val e = i.e.asInstanceOf[CommonCorePopFake]
      e.m should equal (Map(0 -> 'H'.toInt))
      e.b should equal (Map('H -> 0))
      e.p should equal (1)
      e.a should equal ('H'.toInt)
      StreamIO.byteArray(io) should equal ("H")
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

    ignore("Hello string") {
      val code =
        """
LDS "Hello" VAR 'H

LDV 'H OUT
"""
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("H")
    }

  }
}
