package io.github.writeonly.resentment.teapot.stack

import io.github.writeonly.resentment.core.impl.StackCoreFake
import io.github.writeonly.resentment.corn.dsl.StackCornDsl
import io.github.writeonly.resentment.teapot.GrayScalarSpec

class UniCornDslSpec extends GrayScalarSpec  {

  describe("A Streamer") {

    ignore("when convertFile file with empty name") {
      val engine = new StackCoreFake
      new StackCornDsl(engine) uld 's ust 's
      new StackCornDsl(engine) uld 's uld 's ust 's
    }
  }

}
