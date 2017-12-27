package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.impl.fake.{ComplexCoreComparator, ComplexCoreFake}
import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.specification.AroundTimeout
import org.specs2.execute._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComplexCoreComparatorBFSpec extends org.specs2.mutable.Specification with AroundTimeout with ScalaCheck {

  implicit def unitAsResult: AsResult[Unit] = new AsResult[Unit] {
    def asResult(u: =>Unit): Result = { u; Success() }
  }

  val value = Gen.choose(0, 256)
  val address = Gen.choose(0, 256)

  "this is a specific property" >> {

    "cconst" >> prop { (s: Int, d: Int) =>
      val comparator = new ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
      comparator {
        _.cconst(s, d)
      }
    }.setGens(value, address)

    "cconst cmv" >> prop { (s: Int, d1: Int, d2 : Int) =>
      val comparator = new ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
      comparator { c =>
        c.cconst(s, d1)
        c.cmv(d1, d2)
      }
    }.setGens(value, address, address)

    "cconst cneg" >> prop { (s: Int, d1: Int) =>
      val comparator = new ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
      comparator { c =>
        c.cconst(s, d1)
        c.cneg(d1)
      }
    }.setGens(value, address)

//    "cconst cnot" >> prop { (s: Int, d1: Int) =>
//      val comparator = new ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
//      comparator { c =>
//        c.cconst(s, d1)
//        c.cnot(d1)
//      }
//    }.setGens(value, address)

  }
}
