package io.github.writeonly.resentment.core.impl.bf

import io.github.writeonly.resentment.fsm.{InterpreterBF, StreamIO}
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComplexCoreBFSpec extends org.specs2.mutable.Specification  {
  "this is my specification" >> {

    "clear 0" >> {
      val out = new ComplexCoreBF(System.out).cclr(0)()
      out must_== "[-]"
    }
    "clear 1" >> {
      val out = new ComplexCoreBF(System.out).cclr(1)()
      out must_== ">[-]"
    }
    "where example 1 must be true" >> {
      val out = new ComplexCoreBF(System.out).cmv(0,1)()
      out must_== ">[-]<[>+<<+>-]<[>+<-]"
    }
    "cconst(1,1)" >> {
      val out = new ComplexCoreBF(System.out).cconst(1,1)()
      out must_== ">[-]+"
      new InterpreterBF(StreamIO.byteArray(), out)().tape(1) must_== 1
    }
    "cconst(2,1)" >> {
      val out = new ComplexCoreBF(System.out).cconst(2,1)()
      out must_== ">[-]++"
      new InterpreterBF(StreamIO.byteArray(), out)().tape(1) must_== 2
    }
  }
}
