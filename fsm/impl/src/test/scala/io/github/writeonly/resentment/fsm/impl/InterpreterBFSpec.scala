package io.github.writeonly.resentment.fsm.impl

import io.github.writeonly.resentment.fsm.api.StreamIO
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InterpreterBFSpec extends org.specs2.mutable.Specification {
  "this is my specification" >> {
    "where code hello world" >> {
      val helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++."
      new InterpreterBF(StreamIO.byteArray(), helloWorld)().streamIO.toString must_== "Hello World!\n"
    }
    "where watchdog intervened" >> {
      new InterpreterBF(StreamIO.byteArray(), "+[]", 10)() must throwA[IllegalArgumentException]
    }
  }
}
