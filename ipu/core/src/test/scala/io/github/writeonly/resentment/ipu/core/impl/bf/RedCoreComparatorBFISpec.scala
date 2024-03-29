package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.execute._
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreComparatorBFISpec extends RedCoreComparatorBFSpec {

  "swap" >> {
    "rmovi rnop" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator {
        _ rmovi (v1, d1) rnop ()
      }
    }.setGens(value, address)

    "rmovi rswap" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rswap(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi rswap" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rswap(d1, d2)
      }
    }.setGens(value, value, address, address)
  }

  "rmov" >> {
    "rmovi rmov" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmov(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmov 1" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmov(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovc" >> prop { (v: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmovc(d1, d2)
      }
    }.setGens(value, address, address)

    "rmovi rmovc 1" >> prop { (v: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v, d1)
        c.rmovc(d1, d1)
      }
    }.setGens(value, address)
  }
  "add" >> {
    "rmovi rmovi radd" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.radd(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi radd" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.radd(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi raddc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.raddc(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi raddc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.raddc(d1, d1)
      }
    }.setGens(value, address)

    "rmovi raddi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.raddi(v2, d1)
      }
    }.setGens(value, address, value)
  }
  "sub" >> {
    "rmovi rmovi rsub" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rsub(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rsub" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rsub(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi rsubc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rsubc(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rsubc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rsubc(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rsubi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rsubi(v2, d1)
      }
    }.setGens(value, address, value)
  }
  "mul" >> {
    "rmovi rmovi rmul" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rmul(d1, d2)
      }
    }.setGens(value, value, shortAddress, shortAddress)

    "rmovi rmul" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmul(d1, d1)
      }
    }.setGens(value, shortAddress)

    "rmovi rmovi rmulc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rmulc(d1, d2)
      }
    }.setGens(value, value, shortAddress, shortAddress)

    "rmovi rmulc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmulc(d1, d1)
      }
    }.setGens(value, shortAddress)

    "rmovi rmuli" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmuli(v2, d1)
      }
    }.setGens(value, address, value)
  }
  "div" >> {
    "rmovi rmovi rdiv" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rdiv(d1, d2)
      }
    }.setGens(valueNonZero, valueNonZero, shortAddress, shortAddress)

    "rmovi rdiv" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rdiv(d1, d1)
      }
    }.setGens(valueNonZero, shortAddress)

    "rmovi rmovi rdivc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rdivc(d1, d2)
      }
    }.setGens(valueNonZero, valueNonZero, shortAddress, shortAddress)

    "rmovi rdivc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rdivc(d1, d1)
      }
    }.setGens(valueNonZero, shortAddress)

    "rmovi rdivi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rdivi(v2, d1)
      }
    }.setGens(value, address, valueNonZero)
  }
  "mod" >> {
    "rmovi rmovi rmod" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rmod(d1, d2)
      }
    }.setGens(valueNonZero, valueNonZero, shortAddress, shortAddress)

    "rmovi rmovi rmodc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rmodc(d1, d2)
      }
    }.setGens(valueNonZero, valueNonZero, shortAddress, shortAddress)

    "rmovi rmodi" >> prop { (v1: Int, d1: Int, v2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmodi(v2, d1)
      }
    }.setGens(value, address, valueNonZero)
  }
  "pow" >> {
    "rmovi rmovi rpow" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rpow(d1, d2)
      }
    }.setGens(shortValuePos, shortValuePos, shortAddress, shortAddress)

    "rmovi rpow" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rpow(d1, d1)
      }
    }.setGens(shortValuePos, shortAddress)

    "rmovi rmovi rpowc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rpowc(d1, d2)
      }
    }.setGens(shortValuePos, shortValuePos, shortAddress, shortAddress)

    "rmovi rpowc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rpowc(d1, d1)
      }
    }.setGens(shortValuePos, shortAddress)

    "rmovi rpowi" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rpowi(v2, d1)
      }
    }.setGens(shortValuePos, shortValuePos, shortAddress)
  }
  "neg" >> {
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
  }
}
