package io.github.writeonly.resentment.core.impl.bf

import io.github.writeonly.resentment.fsm.{InterpreterBF, StreamIO}
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class ComplexCoreBFSpec extends org.specs2.mutable.Specification
  with AroundTimeout
  {
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
    "cconst(1,2)" >> {
      val out = new ComplexCoreBF(System.out).cconst(1,2)()
      out must_== ">>[-]+"
      new InterpreterBF(StreamIO.byteArray(), out)().tape(2) must_== 1
    }
    "cconst(2,1)" >> {
      val out = new ComplexCoreBF(System.out).cconst(2,1)()
      out must_== ">[-]++"
      new InterpreterBF(StreamIO.byteArray(), out)().tape(1) must_== 2
    }
    "cconst(-2,1)" >> {
      val out = new ComplexCoreBF(System.out).cconst(-2,1)()
      out must_== ">[-]--"
      new InterpreterBF(StreamIO.byteArray(), out)().tape.s(1) must_== -2
    }
    "cconst(2,1) cmv(1,2)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(2,1)() + core.cmv(1,2)()
      out must_== ">[-]++>[-]<[>+<<<+>>-]<<[>>+<<-]"
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 0
      tape(1) must_== 2
      tape(2) must_== 2
    }
    "cconst(2,0) cconst(3,1) cadd(0,1)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(2,0)() + core.cconst(3,1)() + core.cadd(0,1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 2
      tape(1) must_== 5
    }
    "cconst(2,0) cconst(3,1) csub(0,1)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(2,0)() + core.cconst(3,1)() + core.csub(0,1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 2
      tape(1) must_== 1
    }
    "cconst(3,0) cconst(2,1) csub(0,1)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(3,0)() + core.cconst(2,1)() + core.csub(0,1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 3
      tape.s(1) must_== -1
    }
    "cconst(2,0) csub(0,0)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(2,0)() + core.csub(0,0)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 0
    }
    "cconst(3,0) csub(0,0)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(3,0)() + core.csub(0,0)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 0
    }
    "cconst(2,0) cconst(3,1) cmul(0,1)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(2,0)() + core.cconst(3,1)() + core.cmul(0,1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 2
      tape(1) must_== 6
    }
    "cconst(3,0) cmul(0,0)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(3,0)() + core.cmul(0,0)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(0) must_== 9
    }

    "cconst(3,1) cconst(1,3) cswap(1,3)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(3,1)() + core.cconst(1,3)() + core.cswap(1,3)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape(1) must_== 1
      tape(3) must_== 3
    }

    "cconst(3,1) cneg(1)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(3,1)() + core.cneg(1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape.s(1) must_== -3
    }

    "cconst(3,1) cnot(1)" >> {
      val core = new ComplexCoreBF(System.out)
      val out = core.cconst(3,1)() + core.cnot(1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().tape
      tape.s(1) must_== -2
    }
    
  }
}
