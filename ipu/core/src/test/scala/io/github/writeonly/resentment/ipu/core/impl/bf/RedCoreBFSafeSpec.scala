package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.fsm.api.StreamIO
import io.github.writeonly.resentment.fsm.impl.InterpreterBF
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreBFSafeSpec extends org.specs2.mutable.Specification
  with AroundTimeout {
  "this is my specification" >> {

    "rlear 0" >> {
      val out = new RedCoreBFSafe().rclr(0)()
      out must_== "[-]"
    }
    "rlear 1" >> {
      val out = new RedCoreBFSafe().rclr(1)()
      out must_== ">[-]"
    }
    "where example 1 must be true" >> {
      val out = new RedCoreBFSafe().rmov(0, 1)()
      out must_== ">[-]<[>+<<+>-]<[>+<-]"
    }
    "mov" >> {
      "rmovi(1,2)" >> {
        val out = new RedCoreBFSafe().rmovi(1, 2)()
        out must_== ">>[-]+"
        new InterpreterBF(StreamIO.byteArray(), out)().memory(2) must_== 1
      }
      "rmovi(2,1)" >> {
        val out = new RedCoreBFSafe().rmovi(2, 1)()
        out must_== ">[-]++"
        new InterpreterBF(StreamIO.byteArray(), out)().memory(1) must_== 2
      }
      "rmovi(-2,1)" >> {
        val out = new RedCoreBFSafe().rmovi(-2, 1)()
        out must_== ">[-]--"
        new InterpreterBF(StreamIO.byteArray(), out)().memory.s(1) must_== -2
      }

      "rmovi(2,1) rmov(1,2)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 1)() + core.rmov(1, 2)()
        out must_== ">[-]++>[-]<[>+<<<+>>-]<<[>>+<<-]"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 0
        memory(1) must_== 2
        memory(2) must_== 2
      }
    }
    "add" >> {
      "rmovi(2,0) rmovi(3,1) radd(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.radd(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 5
      }
      "raddi(2,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.raddi(2, 1)()
        out must_== ">++"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 2
      }
      "rmovi(3,1) raddi(2,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 1)() + core.raddi(2, 1)()
        out must_== ">[-]+++++"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 5
      }
    }
    "sub" >> {
      "rmovi(2,0) rmovi(3,1) rsub(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.rsub(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }
      "rmovi(3,0) rmovi(2,1) rsub(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 0)() + core.rmovi(2, 1)() + core.rsub(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 3
        memory.s(1) must_== -1
      }
      "rmovi(2,0) rsub(0,0)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rsub(0, 0)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 0
      }
      "rmovi(3,0) rsub(0,0)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 0)() + core.rsub(0, 0)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 0
      }
      "rsubi(2,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rsubi(2, 1)()
        out must_== ">--"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== -2
      }
      "rmovi(3,1) rsubi(2,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 1)() + core.rsubi(2, 1)()
        out must_== ">[-]+++--"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 1
      }
      "rsubi(3,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rsubi(3, 1)()
        out must_== ">---"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory.s(1) must_== -3
      }
      "rmovi(2,1) rsubi(3,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 1)() + core.rsubi(3, 1)()
        out must_== ">[-]++---"
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory.s(1) must_== -1
      }
    }
    "mul" >> {
      "rmovi(2,0) rmovi(3,1) rmul(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.rmul(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 6
      }
      "rmovi(3,0) rmul(0,0)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 0)() + core.rmul(0, 0)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 9
      }

      "rmovi(2,1) rmuli(3,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 1)() + core.rmuli(3, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 6
      }
    }
    "div" >> {
      "rmovi(3,1) rmovi(6, 2) rdiv(1,2)" >> {
        val core = new RedCoreBFSafe
        val out = core.rmovi(3, 1)() + core.rmovi(6, 2)() + core.rdiv(1, 2)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 3
        memory(2) must_== 2
      }

      "rmovi(6, 2) rdivi(3,2)" >> {
        val core = new RedCoreBFSafe
        val out = core.rmovi(6, 2)() + core.rdivi(3, 2)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(2) must_== 2
      }
    }
    "mod" >> {
      "rmovi(3,1) rmovi(6, 2) rmod(1,2)" >> {
        val core = new RedCoreBFSafe
        val out = core.rmovi(3, 1)() + core.rmovi(6, 2)() + core.rmod(1, 2)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 3
        memory(2) must_== 3
      }

      "rmovi(6, 2) rmodi(3,2)" >> {
        val core = new RedCoreBFSafe
        val out = core.rmovi(6, 2)() + core.rmodi(3, 2)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(2) must_== 3
      }
    }
    "pow" >> {
      "rmovi(2,0) rmovi(3,1) rpow(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.rpow(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 9
      }

      "rmovi(3,0) rmovi(2,1) rpow(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 0)() + core.rmovi(2, 1)() + core.rpow(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 3
        memory(1) must_== 8
      }

      "rmovi(3,1) rpowi(2,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 1)() + core.rpowi(2, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 9
      }

      "rmovi(2,1) rpowi(3,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 1)() + core.rpowi(3, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(1) must_== 8
      }
    }
    "rmovi(3,1) rmovi(1,3) rswap(1,3)" >> {
      val core = new RedCoreBFSafe()
      val out = core.rmovi(3, 1)() + core.rmovi(1, 3)() + core.rswap(1, 3)()
      val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
      memory(1) must_== 1
      memory(3) must_== 3
    }

    "rmovi(3,1) rneg(1)" >> {
      val core = new RedCoreBFSafe()
      val out = core.rmovi(3, 1)() + core.rneg(1)()
      val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
      memory.s(1) must_== -3
    }

    "rmovi(3,1) rnot(1)" >> {
      val core = new RedCoreBFSafe()
      val out = core.rmovi(3, 1)() + core.rnot(1)()
      val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
      memory.s(1) must_== 0
    }
    "eq" >> {
      "rmovi(2,0) rmovi(3,1) req(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.req(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) req(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(2, 1)() + core.req(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }
    }
    "ne" >> {
      "rmovi(2,0) rmovi(3,1) rne(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.rne(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(2,0) rmovi(2,1) rne(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(2, 1)() + core.rne(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }
    }
    "le" >> {
      "rmovi(2,0) rmovi(3,1) rle(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.rle(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) rle(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(2, 1)() + core.rle(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(3,0) rmovi(2,1) rle(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 0)() + core.rmovi(2, 1)() + core.rle(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 3
        memory(1) must_== 1
      }
    }

    "lt" >> {
      "rmovi(2,0) rmovi(3,1) rlt(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(3, 1)() + core.rlt(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) rlt(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(2, 0)() + core.rmovi(2, 1)() + core.rlt(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(3,0) rmovi(2,1) rlt(0,1)" >> {
        val core = new RedCoreBFSafe()
        val out = core.rmovi(3, 0)() + core.rmovi(2, 1)() + core.rlt(0, 1)()
        val memory = new InterpreterBF(StreamIO.byteArray(), out)().memory
        memory(0) must_== 3
        memory(1) must_== 1
      }
    }
  }
}
