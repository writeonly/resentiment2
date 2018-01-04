package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.execute._
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreComparatorBFSpec extends org.specs2.mutable.Specification with AroundTimeout with ScalaCheck {

  implicit def unitAsResult: AsResult[Unit] = new AsResult[Unit] {
    def asResult(u: => Unit): Result = {
      u
      Success()
    }
  }

  private val value = Gen.choose(0, 256)
  private val valueNonZero = Gen.choose(1, 255)
  private val address = Gen.choose(1, 256)
  private val shortAddress = Gen.choose(1, 4)

  "this is a specific property" >> {

    "cmovi" >> prop { (v: Int, d: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator {
        _ rmovi(v, d)
      }
    }.setGens(value, address)

    "cmovi cmov" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmov(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cadd" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.radd(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cadd" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.radd(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi caddi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.raddi(v2, d1)
      }
    }.setGens(value, address, value)

    "cmovi csub" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rsub(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi csub" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rsub(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi csubi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rsubi(v2, d1)
      }
    }.setGens(value, address, value)

    "cmovi cmul" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmul(d1, d2)
      }
    }.setGens(value, shortAddress, shortAddress)

    "cmovi cmovi cmul" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rmul(d1, d2)
      }
    }.setGens(value, value, shortAddress, shortAddress)

    "cmovi cmuli" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmuli(v2, d1)
      }
    }.setGens(value, address, value)

    "cmovi rdiv" >> prop { (v: Int, d1: Int, d2 : Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rdiv(d1, d2)
      }
    }.setGens(valueNonZero, address, address)

    "cmovi cmovi rdiv" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rdiv(d1, d2)
      }
    }.setGens(valueNonZero, valueNonZero, shortAddress, shortAddress)

    "cmovi rdivi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rdivi(v2, d1)
      }
    }.setGens(value, address, valueNonZero)

    "cmovi cneg" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rneg(d1)
      }
    }.setGens(value, address)

    "cmovi cng1" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rng1(d1)
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
        c.rmovi(v, d1)
        c.req(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi ceq" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.req(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi cne" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rne(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cne" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rne(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi cle" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rle(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi cle" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rle(d1, d2)
      }
    }.setGens(value, value, address, address)

    "cmovi clt" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rlt(d1, d2)
      }
    }.setGens(value, address, address)

    "cmovi cmovi clt" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rlt(d1, d2)
      }
    }.setGens(value, value, address, address)
  }
}
