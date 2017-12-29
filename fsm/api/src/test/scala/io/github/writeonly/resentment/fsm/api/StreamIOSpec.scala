package io.github.writeonly.resentment.fsm.api

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StreamIOSpec extends org.specs2.mutable.Specification {
  "this is my specification" >> {
    "where stream is applied" >> {
      val stream = StreamIO.byteArray()
      stream.apply(_ toString) must_== stream
    }
  }
}
