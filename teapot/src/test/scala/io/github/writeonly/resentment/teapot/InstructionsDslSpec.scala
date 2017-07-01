package io.github.writeonly.resentment.teapot

import io.github.writeonly.resentiment.teapot.engine2.InstructionsFake
import io.github.writeonly.resentiment.teapot.dsl2.InstructionsDsl

class InstructionsDslSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val engine = new InstructionsFake
      new InstructionsDsl(engine) ld 's st 's
    }
  }

}
