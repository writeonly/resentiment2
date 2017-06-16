package io.github.writeonly.resentment.teapot

import io.github.writeonly.resentiment.teapot.core.InstructionsInterpreter
import io.github.writeonly.resentiment.teapot.dsl.InstructionsDsl

class InstructionsSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    it("when convertFile file with empty name") {
      val engine = new InstructionsInterpreter
      new InstructionsDsl(engine) ld 's st 's
    }
  }

}
