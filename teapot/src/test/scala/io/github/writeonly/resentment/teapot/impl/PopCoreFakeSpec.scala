package io.github.writeonly.resentment.teapot.impl

import io.github.writeonly.resentment.core.impl.PopCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.dsl.PopCornDsl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class PopCoreFakeSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val io : StreamIO = StreamIO.byteArray("")
      val engine = new PopCoreFake(io)
      new PopCornDsl(engine) uld 's ust 's
      new PopCornDsl(engine) uld 's uld 's ust 's
    }
  }

}
