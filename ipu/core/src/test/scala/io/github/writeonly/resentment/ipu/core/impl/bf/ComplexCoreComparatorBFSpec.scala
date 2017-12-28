package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.execute._
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class ComplexCoreComparatorBFSpec extends org.specs2.mutable.Specification with AroundTimeout with ScalaCheck {

  implicit def unitAsResult: AsResult[Unit] = new AsResult[Unit] {
    def asResult(u: => Unit): Result = {
      u; Success()
    }
  }

  private val value = Gen.choose(0, 256)
  private val address = Gen.choose(0, 256)

  "this is a specific property" >> {

    "cconst" >> prop { (v: Int, d: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator {
        _.cconst(v, d)
      }
    }.setGens(value, address)

    "cconst cmov" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.cmov(d1, d2)
      }
    }.setGens(value, address, address)

    "cconst cadd" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.cadd(d1, d2)
      }
    }.setGens(value, address, address)

    "cconst csub" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.csub(d1, d2)
      }
    }.setGens(value, address, address)

    "cconst cmul" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.cmul(d1, d2)
      }
    }.setGens(value, address, address)

    //    "cconst cdiv" >> prop { (v: Int, d1: Int, d2 : Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.cconst(v, d1)
    //        c.cdiv(d1, d2)
    //      }
    //    }.setGens(value, address, address)

    "cconst cneg" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.cneg(d1)
      }
    }.setGens(value, address)

    "cconst cng1" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.cng1(d1)
      }
    }.setGens(value, address)

    //    "cconst cnot" >> prop { (s: Int, d1: Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.cconst(s, d1)
    //        c.cnot(d1)
    //      }
    //    }.setGens(value, address)

    "cconst ceq" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.ceq(d1, d2)
      }
    }.setGens(value, address, address)

    "cconst cne" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cconst(v, d1)
        c.cne(d1, d2)
      }
    }.setGens(value, address, address)

    //    "cconst cle" >> prop { (v: Int, d1: Int, d2 : Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.cconst(v, d1)
    //        c.cle(d1, d2)
    //      }
    //    }.setGens(value, address, address)
    //
    //    "cconst clt" >> prop { (v: Int, d1: Int, d2 : Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.cconst(v, d1)
    //        c.clt(d1, d2)
    //      }
    //    }.setGens(value, address, address)

  }
}
