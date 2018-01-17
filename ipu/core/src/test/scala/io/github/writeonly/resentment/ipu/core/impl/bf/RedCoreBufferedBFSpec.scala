package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreBufferedBFSpec extends org.specs2.mutable.Specification
  with AroundTimeout {
  "this is my specification" >> {

    "swap" >> {
      "rmovi(3,1) rswap(1,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.rswap(1, 1)
        val memory = core.apply().memory
        memory(1) must_== 3
      }
      "rmovi(3,1) rmovi(1,3) rswap(1,3)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.rmovi(1, 3)
        core.rswap(1, 3)
        val memory = core.apply().memory
        memory(1) must_== 1
        memory(3) must_== 3
      }
    }
    "mov" >> {
      "rmovi(1,2)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(1, 2)
        val memory = core.apply().memory
        memory(2) must_== 1
      }
      "rmovi(2,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 1)
        val memory = core.apply().memory
        memory(1) must_== 2
      }
      "rmovi(-2,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(-2, 1)
        val memory = core.apply().memory
        memory(1) must_== -2
      }
      "rmovi(3,1) rmovc(1,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(1, 3)
        core.rmovc(1, 1)
        val memory = core.apply().memory
        memory(1) must_== 0
      }
      "rmovi(2,1) rmov(1,2)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 1)
        core.rmov(1, 2)
        val memory = core.apply().memory
        memory(0) must_== 0
        memory(1) must_== 2
        memory(2) must_== 2
      }
      "rmovi(2,1) rmov(1,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 1)
        core.rmov(1, 1)
        val memory = core.apply().memory
        memory(0) must_== 0
        memory(1) must_== 2
      }
    }
    "add" >> {
      "rmovi(2,0) rmovi(3,1) radd(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.radd(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 5
      }
      "raddi(2,1)" >> {
        val core = new RedCoreBufferedBF
        core.raddi(2, 1)
        val memory = core.apply().memory
        memory(1) must_== 2
      }
      "rmovi(3,1) raddi(2,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.raddi(2, 1)
        val memory = core.apply().memory
        memory(1) must_== 5
      }
    }
    "sub" >> {
      "rmovi(2,0) rmovi(3,1) rsub(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rsub(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }
      "rmovi(3,0) rmovi(2,1) rsub(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rsub(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 3
        memory(1) must_== -1
      }
      "rmovi(2,0) rsub(0,0)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rsub(0, 0)
        val memory = core.apply().memory
        memory(0) must_== 0
      }
      "rmovi(3,0) rsub(0,0)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 0)
        core.rsub(0, 0)
        val memory = core.apply().memory
        memory(0) must_== 0
      }
      "rsubi(2,1)" >> {
        val core = new RedCoreBufferedBF
        core.rsubi(2, 1)
        val memory = core.apply().memory
        memory(1) must_== -2
      }
      "rmovi(3,1) rsubi(2,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.rsubi(2, 1)
        val memory = core.apply().memory
        memory(1) must_== 1
      }
      "rsubi(3,1)" >> {
        val core = new RedCoreBufferedBF
        core.rsubi(3, 1)
        val memory = core.apply().memory
        memory(1) must_== -3
      }
      "rmovi(2,1) rsubi(3,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 1)
        core.rsubi(3, 1)
        val memory = core.apply().memory
        memory(1) must_== -1
      }
    }
    "mul" >> {
      "rmovi(2,0) rmovi(3,1) rmul(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rmul(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 6
      }
      "rmovi(3,0) rmul(0,0)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 0)
        core.rmul(0, 0)
        val memory = core.apply().memory
        memory(0) must_== 9
      }
    }
    "neg" >> {
      "rmovi(3,1) rneg(1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.rneg(1)
        val memory = core.apply().memory
        memory(1) must_== -3
      }

      "rmovi(-2,1) rneg(1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(-2, 1)
        core.rneg(1)
        val memory = core.apply().memory
        memory(1) must_== 2
      }
    }
    "ng1" >> {
      "rmovi(3,1) rng1(1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.rng1(1)
        val memory = core.apply().memory
        memory(1) must_== -2
      }

      "rmovi(-2,1) rng1(1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(-2, 1)
        core.rng1(1)
        val memory = core.apply().memory
        memory(1) must_== 3
      }
    }
    "not" >> {
      "rmovi(3,1) rnot(1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.rnot(1)
        val interpreter = core.apply()
        val memory = interpreter.memory
        memory(1) must_== 0
      }
    }
    "eq" >> {
      "rmovi(3,1) req(1,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 1)
        core.req(1, 1)
        val memory = core.apply().memory
        memory(1) must_== 1
      }
      "rmovi(2,0) rmovi(3,1) req(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.req(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) req(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.req(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }
    }
    "ne" >> {
      "rmovi(2,0) rmovi(3,1) rne(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rne(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(2,0) rmovi(2,1) rne(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.rne(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }
      "rmovi(2,1) rnec(1,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 1)
        core.rnec(1, 1)
        val memory = core.apply().memory
        memory(1) must_== 0
      }
    }
    "le" >> {
      "rmovi(2,0) rmovi(3,1) rle(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rle(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) rle(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.rle(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(3,0) rmovi(2,1) rle(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rle(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 3
        memory(1) must_== 1
      }
    }
    "lt" >> {
      "rmovi(2,0) rmovi(3,1) rlt(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rlt(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) rlt(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.rlt(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(3,0) rmovi(2,1) rlt(0,1)" >> {
        val core = new RedCoreBufferedBF
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rlt(0, 1)
        val memory = core.apply().memory
        memory(0) must_== 3
        memory(1) must_== 1
      }
    }
  }
}
