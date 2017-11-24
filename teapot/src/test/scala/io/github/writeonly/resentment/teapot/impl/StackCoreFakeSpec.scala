package io.github.writeonly.resentment.teapot.impl

import io.github.writeonly.resentment.core.impl.StackCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.dsl.StackCornDsl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class StackCoreFakeSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val io : StreamIO = StreamIO.byteArray("")
      val engine = new StackCoreFake(io)
      new StackCornDsl(engine) uld 's ust 's
      new StackCornDsl(engine) uld 's uld 's ust 's
    }
  }

}
