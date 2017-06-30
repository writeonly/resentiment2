package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.glue.Phaser
import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLLAsm
import io.github.writeonly.resentiment.teapot.phases.generators.Interpreter
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class OutSpec extends GrayScalarSpec {
  describe("A Streamer") {
    val parser = new AnalyzerLLAsm
    val interpreter = new Interpreter
    val compiler = new Phaser(parser, interpreter)

    val code = "CH 'A' OUT"

    it("CH 'A' OUT") {
       compiler(code) should equal ('A')
    }
  }
}
