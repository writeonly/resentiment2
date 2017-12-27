package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.impl.fake.{ComplexCoreComparator, ComplexCoreFake}
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.specification.AroundTimeout
import org.specs2.execute._

class ComplexCoreComparatorBFSpec extends org.specs2.mutable.Specification with AroundTimeout with ScalaCheck {

  implicit def unitAsResult: AsResult[Unit] = new AsResult[Unit] {
    def asResult(u: =>Unit): Result = { u; Success() }
  }
  "this is a specific property" >> {

    "cconst" >> prop { (s: Int, d: Int) =>
      val comparator = new ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
      comparator {
        _.cconst(s, d)
      }
    }.setGens(Gen.choose(0, 256), Gen.choose(0, 256))

    "cconst cmv" >> prop { (s: Int, d1: Int, d2 : Int) =>
      val comparator = new ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
      comparator { c =>
        c.cconst(s, d1)
        c.cmv(d1, d2)
      }
    }.setGens(Gen.choose(0, 256), Gen.choose(0, 256), Gen.choose(0, 256))
  }
}
