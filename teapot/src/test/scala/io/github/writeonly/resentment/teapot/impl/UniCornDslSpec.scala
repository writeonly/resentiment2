package io.github.writeonly.resentment.teapot.impl

import io.github.writeonly.resentment.core.impl.UniCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.dsl.UniCornDsl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class UniCornDslSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val io : StreamIO = StreamIO.byteArray("")
      val engine = new UniCoreFake(io)
      new UniCornDsl(engine) uld 's ust 's
    }
  }

}
