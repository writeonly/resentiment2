package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreBufferedBFSpec extends org.specs2.mutable.Specification
  with AroundTimeout {
  "this is my specification" >> {

    "cmovi(1,2)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(1, 2)
      val memory = core.apply().memory
      memory(2) must_== 1
    }
    "cmovi(2,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 1)
      val memory = core.apply().memory
      memory(1) must_== 2
    }
    "cmovi(-2,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(-2, 1)
      val memory = core.apply().memory
      memory(1) must_== -2
    }
    "cmovi(2,1) cmov(1,2)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 1)
      core.cmov(1, 2)
      val tape = core.apply().memory
      tape(0) must_== 0
      tape(1) must_== 2
      tape(2) must_== 2
    }
    "cmovi(2,1) cmov(1,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 1)
      core.cmov(1, 1)
      val tape = core.apply().memory
      tape(0) must_== 0
      tape(1) must_== 2
    }

    "cmovi(2,0) cmovi(3,1) cadd(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.cadd(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 5
    }
    "caddi(2,1)" >> {
      val core = new RedCoreBufferedBF
      core.caddi(2, 1)
      val tape = core.apply().memory
      tape(1) must_== 2
    }
    "cmovi(3,1) caddi(2,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 1)
      core.caddi(2, 1)
      val tape = core.apply().memory
      tape(1) must_== 5
    }
    "cmovi(2,0) cmovi(3,1) csub(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.csub(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }
    "cmovi(3,0) cmovi(2,1) csub(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 0)
      core.cmovi(2, 1)
      core.csub(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 3
      tape(1) must_== -1
    }
    "cmovi(2,0) csub(0,0)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.csub(0, 0)
      val tape = core.apply().memory
      tape(0) must_== 0
    }
    "cmovi(3,0) csub(0,0)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 0)
      core.csub(0, 0)
      val tape = core.apply().memory
      tape(0) must_== 0
    }
    "csubi(2,1)" >> {
      val core = new RedCoreBufferedBF
      core.csubi(2, 1)
      val tape = core.apply().memory
      tape(1) must_== -2
    }
    "cmovi(3,1) csubi(2,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 1)
      core.csubi(2, 1)
      val tape = core.apply().memory
      tape(1) must_== 1
    }
    "csubi(3,1)" >> {
      val core = new RedCoreBufferedBF
      core.csubi(3, 1)
      val tape = core.apply().memory
      tape(1) must_== -3
    }
    "cmovi(2,1) csubi(3,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 1)
      core.csubi(3, 1)
      val tape = core.apply().memory
      tape(1) must_== -1
    }
    "cmovi(2,0) cmovi(3,1) cmul(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.cmul(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 6
    }
    "cmovi(3,0) cmul(0,0)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 0)
      core.cmul(0, 0)
      val tape = core.apply().memory
      tape(0) must_== 9
    }

    "cmovi(3,1) cmovi(1,3) cswap(1,3)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 1)
      core.cmovi(1, 3)
      core.cswap(1, 3)
      val tape = core.apply().memory
      tape(1) must_== 1
      tape(3) must_== 3
    }

    "cmovi(3,1) cneg(1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 1)
      core.cneg(1)
      val tape = core.apply().memory
      tape(1) must_== -3
    }

    "cmovi(-2,1) cneg(1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(-2, 1)
      core.cneg(1)
      val tape = core.apply().memory
      tape(1) must_== 2
    }

    "cmovi(3,1) cng1(1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 1)
      core.cng1(1)
      val tape = core.apply().memory
      tape(1) must_== -2
    }

    "cmovi(-2,1) cng1(1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(-2, 1)
      core.cng1(1)
      val tape = core.apply().memory
      tape(1) must_== 3
    }

    "cmovi(3,1) cnot(1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 1)
      core.cnot(1)
      val interpreter = core.apply()
      val tape = interpreter.memory
      tape(1) must_== -2
    }

    "cmovi(2,0) cmovi(3,1) ceq(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.ceq(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cmovi(2,0) cmovi(2,1) ceq(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(2, 1)
      core.ceq(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }

    "cmovi(2,0) cmovi(3,1) cne(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.cne(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }

    "cmovi(2,0) cmovi(2,1) cne(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(2, 1)
      core.cne(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }


    "cmovi(2,0) cmovi(3,1) cge(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.cle(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cmovi(2,0) cmovi(2,1) cge(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(2, 1)
      core.cle(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cmovi(3,0) cmovi(2,1) cge(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 0)
      core.cmovi(2, 1)
      core.cle(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 3
      tape(1) must_== 1
    }

    "cmovi(2,0) cmovi(3,1) cgt(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(3, 1)
      core.clt(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 0
    }

    "cmovi(2,0) cmovi(2,1) cgt(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(2, 0)
      core.cmovi(2, 1)
      core.clt(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 2
      tape(1) must_== 1
    }

    "cmovi(3,0) cmovi(2,1) cgt(0,1)" >> {
      val core = new RedCoreBufferedBF
      core.cmovi(3, 0)
      core.cmovi(2, 1)
      core.clt(0, 1)
      val tape = core.apply().memory
      tape(0) must_== 3
      tape(1) must_== 1
    }

  }
}
