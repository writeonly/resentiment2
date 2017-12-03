package io.github.writeonly.resentment.core.impl.bf

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComplexCoreBFSpec extends org.specs2.mutable.Specification  {
  "this is my specification" >> {
    val core = new ComplexCoreBF(System.out)
    "where example 1 must be true" >> {
      core.cmv(0,1)() must_== ">[-]<[>+<<+>-]<[>+<-]"
    }
    "where example 2 must be true" >> {
      2 must_== 2
    }
  }
}
