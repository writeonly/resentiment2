package io.github.writeonly.resentment.ipu.core.impl.fake

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreFakeSpec
    extends org.specs2.mutable.Specification
    with AroundTimeout {
  "this is my specification" >> {

    "rmovi(3,1) rmovi(1,3) rswap(1,3)" >> {
      val core = new RedCoreFake
      core.rmovi(3, 1)
      core.rmovi(1, 3)
      core.rswap(1, 3)
      val memory = core.memory
      memory(1) must_== 1
      memory(3) must_== 3
    }
    "mov" >> {
      "rmovi(1,2)" >> {
        val core = new RedCoreFake
        core.rmovi(1, 2)
        core.memory(2) must_== 1
      }
      "rmovi(2,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 1)
        core.memory(1) must_== 2
      }
      "rmovi(-2,1)" >> {
        val core = new RedCoreFake
        core.rmovi(-2, 1)
        core.memory(1) must_== -2
      }
      "rmovi(2,1) rmov(1,2)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 1)
        core.rmov(1, 2)
        val memory = core.memory
        memory(0) must_== 0
        memory(1) must_== 2
        memory(2) must_== 2
      }
    }
    "add " >> {
      "rmovi(2,0) rmovi(3,1) radd(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.radd(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 5
      }
      "rmovi(3,1) raddi(2,1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.raddi(2, 1)
        val memory = core.memory
        memory(1) must_== 5
      }
    }
    "sub" >> {
      "rmovi(2,0) rmovi(3,1) rsub(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rsub(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 1
      }
      "rmovi(3,0) rmovi(2,1) rsub(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rsub(0, 1)
        val memory = core.memory
        memory(0) must_== 3
        memory(1) must_== -1
      }
      "rmovi(2,0) rsub(0,0)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rsub(0, 0)
        val memory = core.memory
        memory(0) must_== 0
      }
      "rmovi(3,0) rsub(0,0)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 0)
        core.rsub(0, 0)
        val memory = core.memory
        memory(0) must_== 0
      }
      "rmovi(3,1) rsubi(2,1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.rsubi(2, 1)
        val memory = core.memory
        memory(1) must_== 1
      }
      "rmovi(2,1) rsubi(3,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 1)
        core.rsubi(3, 1)
        val memory = core.memory
        memory(1) must_== -1
      }
    }
    "mul" >> {
      "rmovi(2,0) rmovi(3,1) rmul(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rmul(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 6
      }
      "rmovi(3,0) rmul(0,0)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 0)
        core.rmul(0, 0)
        val memory = core.memory
        memory(0) must_== 9
      }
    }
    "div" >> {
      "rmovi(3,1) rmovi(6, 2) rdiv(1,2)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.rmovi(6, 2)
        core.rdiv(1, 2)
        val memory = core.memory
        memory(1) must_== 3
        memory(2) must_== 2
      }
    }
    "pow" >> {
      "rmovi(2,0) rmovi(3,1) rpow(0,1)" >> {
        val core = new RedCoreFake()
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rpow(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 9
      }

      "rmovi(3,0) rmovi(2,1) rpow(0,1)" >> {
        val core = new RedCoreFake()
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rpow(0, 1)
        val memory = core.memory
        memory(0) must_== 3
        memory(1) must_== 8
      }

      "rmovi(3,1) rpow(2,1)" >> {
        val core = new RedCoreFake()
        core.rmovi(3, 1)
        core.rpowi(2, 1)
        val memory = core.memory
        memory(1) must_== 9
      }

      "rmovi(2,1) rpow(3,1)" >> {
        val core = new RedCoreFake()
        core.rmovi(2, 1)
        core.rpowi(3, 1)
        val memory = core.memory
        memory(1) must_== 8
      }
    }
    "neg" >> {
      "rmovi(3,1) rneg(1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.rneg(1)
        val memory = core.memory
        memory(1) must_== -3
      }

      "rmovi(-2,1) rneg(1)" >> {
        val core = new RedCoreFake
        core.rmovi(-2, 1)
        core.rneg(1)
        val memory = core.memory
        memory(1) must_== 2
      }
    }
    "ng1" >> {
      "rmovi(3,1) rng1(1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.rng1(1)
        val memory = core.memory
        memory(1) must_== -2
      }

      "rmovi(-2,1) rng1(1)" >> {
        val core = new RedCoreFake
        core.rmovi(-2, 1)
        core.rng1(1)
        val memory = core.memory
        memory(1) must_== 3
      }
    }
    "not" >> {
      "rmovi(3,1) rnot(1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.rnot(1)
        val memory = core.memory
        memory(1) must_== 0
      }

      "rmovi(0,1) rnot(1)" >> {
        val core = new RedCoreFake
        core.rmovi(0, 1)
        core.rnot(1)
        val memory = core.memory
        memory(1) must_== 1
      }
    }
    "tau" >> {
      "rmovi(3,1) rtau(1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 1)
        core.rtau(1)
        val memory = core.memory
        memory(1) must_== 1
      }

      "rmovi(0,1) rtau(1)" >> {
        val core = new RedCoreFake
        core.rmovi(0, 1)
        core.rtau(1)
        val memory = core.memory
        memory(1) must_== 0
      }
    }
    "eq" >> {
      "rmovi(2,0) rmovi(3,1) req(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.req(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(2,0) rmovi(2,1) req(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.req(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 1
      }
    }
    "ne" >> {
      "rmovi(2,0) rmovi(3,1) rne(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rne(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(2,0) rmovi(2,1) rne(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.rne(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 0
      }
    }
    "le" >> {
      "rmovi(2,0) rmovi(3,1) rle(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rle(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(2,0) rmovi(2,1) rle(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.rle(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(3,0) rmovi(2,1) rle(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rle(0, 1)
        val memory = core.memory
        memory(0) must_== 3
        memory(1) must_== 0
      }
    }
    "lt" >> {
      "rmovi(2,0) rmovi(3,1) rlt(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(3, 1)
        core.rlt(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 1
      }

      "rmovi(2,0) rmovi(2,1) rlt(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(2, 0)
        core.rmovi(2, 1)
        core.rlt(0, 1)
        val memory = core.memory
        memory(0) must_== 2
        memory(1) must_== 0
      }

      "rmovi(3,0) rmovi(2,1) rlt(0,1)" >> {
        val core = new RedCoreFake
        core.rmovi(3, 0)
        core.rmovi(2, 1)
        core.rlt(0, 1)
        val memory = core.memory
        memory(0) must_== 3
        memory(1) must_== 0
      }
    }
  }
}
