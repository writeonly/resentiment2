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
      compiler(io)(code)
      StreamIO.byteArray(io) should equal ("Hello")
    }

  }
}
