package io.github.writeonly.resentment.teapot

import io.github.writeonly.resentiment.teapot.dsl2.InstructionsDsl
import io.github.writeonly.resentiment.teapot.engine2.InstructionsFake

class InstructionsDslOperandSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    it("when convertFile file with empty name") {
      val engine = new InstructionsFake
      new InstructionsDsl(engine) ld 's st 's
    }
  }

}
