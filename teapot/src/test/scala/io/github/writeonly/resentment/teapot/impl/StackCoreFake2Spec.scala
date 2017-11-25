package io.github.writeonly.resentment.teapot.impl

import io.github.writeonly.resentment.core.impl.{StackCoreFake, UniCore2Fake}
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.compilator.Compilator
import io.github.writeonly.resentment.corn.compilator.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentment.corn.compilator.generators.GeneratorImpl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class StackCoreFake2Spec extends GrayScalarSpec {
  describe(classOf[StackCoreFake].toString) {
    val compiler = (io: StreamIO) => new Compilator(new AnalyzerLLAsm, new GeneratorImpl(new StackCoreFake(io)))

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
//      val i = c.backEnd.asInstanceOf[GeneratorImpl]
//      val e = i.e.asInstanceOf[StackCoreFake]
//      e.stack should equal (Map(0 -> 'H'.toInt))
//      e.symbols should equal (Map('H -> 0))
//      e.r should equal (1)
//      e.a should equal ('H'.toInt)
      StreamIO.byteArray(io) should equal ("H")
    }


    it("He variable") {
      val code =
        """
LDC 'H' VAR 'H
LDC 'e' VAR 'e

LDV 'H OUT
LDV 'e OUT


"""
      val io = StreamIO.byteArray("")
      val c = compiler(io)
      c(code)
//      val i = c.backEnd.asInstanceOf[GeneratorImpl]
//      val e = i.e.asInstanceOf[StackCoreFake]
//      e.symbols should equal (Map('e -> 1, 'H -> 0))
//      e.stack should equal (Map(0 -> 'H'.toInt))
//      e.r should equal (1)
      StreamIO.byteArray(io) should equal ("He")
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
      val c = compiler(io)
      c(code)
//      val i = c.backEnd.asInstanceOf[GeneratorImpl]
//      val e = i.e.asInstanceOf[StackCoreFake]
//      e.stack should equal (Map(0 -> 'H'.toInt))
//      e.symbols should equal (Map('H -> 0))
//      e.r should equal (1)
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
