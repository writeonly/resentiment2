package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.fsm.api.StreamIO
import io.github.writeonly.resentment.fsm.impl.InterpreterBF
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class ComplexCoreBFSafeSpec extends org.specs2.mutable.Specification
  with AroundTimeout {
  "this is my specification" >> {

    "clear 0" >> {
      val out = new ComplexCoreBFSafe().cclr(0)()
      out must_== "[-]"
    }
    "clear 1" >> {
      val out = new ComplexCoreBFSafe().cclr(1)()
      out must_== ">[-]"
    }
    "where example 1 must be true" >> {
      val out = new ComplexCoreBFSafe().cmov(0, 1)()
      out must_== ">[-]<[>+<<+>-]<[>+<-]"
    }
    "cconst(1,2)" >> {
      val out = new ComplexCoreBFSafe().cconst(1, 2)()
      out must_== ">>[-]+"
      new InterpreterBF(StreamIO.byteArray(), out)().memory(2) must_== 1
    }
    "cconst(2,1)" >> {
      val out = new ComplexCoreBFSafe().cconst(2, 1)()
      out must_== ">[-]++"
      new InterpreterBF(StreamIO.byteArray(), out)().memory(1) must_== 2
    }
    "cconst(-2,1)" >> {
      val out = new ComplexCoreBFSafe().cconst(-2, 1)()
      out must_== ">[-]--"
      new InterpreterBF(StreamIO.byteArray(), out)().memory.s(1) must_== -2
    }
    "cconst(2,1) cmv(1,2)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 1)() + core.cmov(1, 2)()
      out must_== ">[-]++>[-]<[>+<<<+>>-]<<[>>+<<-]"
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 0
      tape(1) must_== 2
      tape(2) must_== 2
    }
    "cconst(2,0) cconst(3,1) cadd(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.cadd(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 5
    }
    "cconst(2,0) cconst(3,1) csub(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.csub(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }
    "cconst(3,0) cconst(2,1) csub(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 0)() + core.cconst(2, 1)() + core.csub(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 3
      tape.s(1) must_== -1
    }
    "cconst(2,0) csub(0,0)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.csub(0, 0)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 0
    }
    "cconst(3,0) csub(0,0)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 0)() + core.csub(0, 0)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 0
    }
    "cconst(2,0) cconst(3,1) cmul(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.cmul(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 6
    }
    "cconst(3,0) cmul(0,0)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 0)() + core.cmul(0, 0)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 9
    }

    "cconst(3,1) cconst(1,3) cswap(1,3)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 1)() + core.cconst(1, 3)() + core.cswap(1, 3)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(1) must_== 1
      tape(3) must_== 3
    }

    "cconst(3,1) cneg(1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 1)() + core.cneg(1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape.s(1) must_== -3
    }

    "cconst(3,1) cnot(1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 1)() + core.cnot(1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape.s(1) must_== -2
    }

    "cconst(2,0) cconst(3,1) ceq(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.ceq(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cconst(2,0) cconst(2,1) ceq(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(2, 1)() + core.ceq(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }

    "cconst(2,0) cconst(3,1) cne(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.cne(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }

    "cconst(2,0) cconst(2,1) cne(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(2, 1)() + core.cne(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }


    "cconst(2,0) cconst(3,1) cge(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.cle(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cconst(2,0) cconst(2,1) cge(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(2, 1)() + core.cle(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cconst(3,0) cconst(2,1) cge(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 0)() + core.cconst(2, 1)() + core.cle(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 3
      tape(1) must_== 1
    }

    "cconst(2,0) cconst(3,1) cgt(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(3, 1)() + core.clt(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cconst(2,0) cconst(2,1) cgt(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(2, 0)() + core.cconst(2, 1)() + core.clt(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }

    "cconst(3,0) cconst(2,1) cgt(0,1)" >> {
      val core = new ComplexCoreBFSafe()
      val out = core.cconst(3, 0)() + core.cconst(2, 1)() + core.clt(0, 1)()
      val tape = new InterpreterBF(StreamIO.byteArray(), out)().memory
      tape(0) must_== 3
      tape(1) must_== 1
    }

  }
}