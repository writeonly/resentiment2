package io.github.writeonly.resentment.teapot

import io.github.writeonly.resentment.core.impl.UniCoreFake
import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.dsl.UniCornDsl

class UniCornDslSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val engine = new UniCoreFake(StreamIO.byteArray(""))
      new UniCornDsl(engine) uld 's ust 's
    }
  }

}
