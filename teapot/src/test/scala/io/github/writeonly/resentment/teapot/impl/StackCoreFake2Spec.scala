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

    it("CH -> pout") {
      val code = "uldc 'A' pout"
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("A")
    }

    it("Hello char") {
      val code =
        """
uldc 'H' pout
uldc 'e' pout
uldc 'l' pout pout
uldc 'o' pout
"""
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("Hello")
    }

    it("H variable") {
      val code =
        """
uldc 'H' uvar 'H
uldv 'H pout
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
uldc 'H' uvar 'H
uldc 'e' uvar 'e

uldv 'H pout
uldv 'e pout


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
uldc 'H' uvar 'H
uldc 'e' uvar 'e
uldc 'l' uvar 'l
uldc 'o' uvar 'o

uldv 'H pout
uldv 'e pout
uldv 'l pout pout
uldv 'o pout
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
ulds "Hello" uvar 'H

uldv 'H pout
"""
      val io = StreamIO.byteArray("")
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("H")
    }

  }
}
