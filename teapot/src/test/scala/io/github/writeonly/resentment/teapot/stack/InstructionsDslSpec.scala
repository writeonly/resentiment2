package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentiment.teapot.stack.InstructionsDsl
import io.github.writeonly.resentiment.teapot.stack.InstructionsFake
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class InstructionsDslSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val engine = new InstructionsFake
      new InstructionsDsl(engine) ld 's st 's
      new InstructionsDsl(engine) ld 's ld 's st 's
    }
  }

}
