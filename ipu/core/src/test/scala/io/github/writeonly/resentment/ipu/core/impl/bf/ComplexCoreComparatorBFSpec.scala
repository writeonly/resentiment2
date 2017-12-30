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
      u
      Success()
    }
  }

  private val value = Gen.choose(0, 256)
  private val address = Gen.choose(1, 256)
  private val shortAddress = Gen.choose(1, 4)

  "this is a specific property" >> {

    "cmovi" >> prop { (v: Int, d: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator {
        _ cmovi(v, d)
      }
    }.setGens(value, address)

    "cmovi cmov" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cmov(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cadd" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cadd(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cadd" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.cadd(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi caddi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.caddi(v2, d1)
      }
    }.setGens(value, address, value)

    "cmovi csub" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.csub(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi csub" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.csub(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi csubi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.csubi(v2, d1)
      }
    }.setGens(value, address, value)

    "cmovi cmul" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cmul(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cmul" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.cmul(d1, d2)
      }
    }.setGens(value, value, shortAddress, shortAddress)

    //    "cmovi cdiv" >> prop { (v: Int, d1: Int, d2 : Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.cmovi(v, d1)
    //        c.cdiv(d1, d2)
    //      }
    //    }.setGens(value, address, address)

    "cmovi cneg" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cneg(d1)
      }
    }.setGens(value, address)

    "cmovi cng1" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cng1(d1)
      }
    }.setGens(value, address)

    //    "cmovi cnot" >> prop { (s: Int, d1: Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.cmovi(s, d1)
    //        c.cnot(d1)
    //      }
    //    }.setGens(value, address)

    "cmovi ceq" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.ceq(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi ceq" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.ceq(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi cne" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cne(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cne" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.cne(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi cle" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.cle(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cle" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.cle(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi clt" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v, d1)
        c.clt(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi clt" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.cmovi(v1, d1)
        c.cmovi(v2, d2)
        c.clt(d1, d2)
      }
    }.setGens(value, value, address, address)
  }
}
