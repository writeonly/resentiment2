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
  private val valueNonNeg = Gen.choose(0, 126)
  private val shortValuePos = Gen.choose(1, 4)
  private val address = Gen.choose(1, 256)
  private val shortAddress = Gen.choose(1, 4)

  "this is a specific property" >> {

    "rmovi" >> prop { (v: Int, d: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator {
        _ rmovi(v, d)
      }
    }.setGens(value, address)

    "rmovi rmov" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmov(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi radd" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.radd(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovi radd" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.radd(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi raddi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.raddi(v2, d1)
      }
    }.setGens(value, address, value)

    "rmovi rsub" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rsub(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovi rsub" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rsub(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rsubi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rsubi(v2, d1)
      }
    }.setGens(value, address, value)

    "rmovi rmul" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmul(d1, d2)
      }
    }.setGens(value, shortAddress, shortAddress)

    "rmovi rmovi rmul" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rmul(d1, d2)
      }
    }.setGens(value, value, shortAddress, shortAddress)

    "rmovi rmuli" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmuli(v2, d1)
      }
    }.setGens(value, address, value)

    "rmovi rdiv" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rdiv(d1, d2)
      }
    }.setGens(valueNonZero, address, address)

    "rmovi rmovi rdiv" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rdiv(d1, d2)
      }
    }.setGens(valueNonZero, valueNonZero, shortAddress, shortAddress)

    "rmovi rdivi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rdivi(v2, d1)
      }
    }.setGens(value, address, valueNonZero)

//    "rmovi rmovi rpow" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
//      val comparator = new ComplexCoreComparatorBF
//      comparator { c =>
//        c.rmovi(v1, d1)
//        c.rmovi(v2, d2)
//        c.rpow(d1, d2)
//      }
//    }.setGens(shortValuePos, shortValuePos, shortAddress, shortAddress)

    "rmovi rneg" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rneg(d1)
      }
    }.setGens(value, address)

    "rmovi rng1" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rng1(d1)
      }
    }.setGens(value, address)

    //    "rmovi rnot" >> prop { (s: Int, d1: Int) =>
    //      val comparator = new ComplexCoreComparatorBF
    //      comparator { c =>
    //        c.rmovi(s, d1)
    //        c.rnot(d1)
    //      }
    //    }.setGens(value, address)

    "rmovi req" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.req(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovi req" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.req(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rne" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rne(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovi rne" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rne(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rle" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rle(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovi rle" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rle(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rle" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rlt(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovi rle" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rlt(d1, d2)
      }
    }.setGens(value, value, address, address)
  }
}
