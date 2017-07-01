package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.glue.Phaser
import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentiment.teapot.phases.generators.Interpreter
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class OutSpec extends GrayScalarSpec {
  describe("A Streamer") {
    val compiler = () => new Phaser(new AnalyzerLLAsm, new Interpreter)

    it("CH -> OUT") {
      val code = "CH 'A' OUT"
      compiler()(code) should equal ("A")
    }

    it("Hello char") {
      val code =
        """
CH 'H' OUT
CH 'e' OUT
CH 'l' OUT OUT
CH 'o' OUT
"""
      compiler()(code) should equal ("Hello")
    }

    ignore("Hello variable") {
      val code =
        """
CH 'H' VBT 'H
CH 'e' VBT 'e
CH 'l' VBT 'l
CH 'o' VBT 'o

LD 'H OUT
LD 'e OUT
LD 'l OUT OUT
LD 'l OUT
"""
      compiler()(code) should equal ("Hello")
    }


  }
}
