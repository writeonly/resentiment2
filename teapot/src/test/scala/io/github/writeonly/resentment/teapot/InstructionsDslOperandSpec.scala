package io.github.writeonly.resentment.teapot

import io.github.writeonly.resentiment.teapot.dsl2.InstructionsDsl
import io.github.writeonly.resentment.core.impl.UniCoreFake

class InstructionsDslOperandSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val engine = new UniCoreFake
      new InstructionsDsl(engine) ld 's st 's
    }
  }

}
