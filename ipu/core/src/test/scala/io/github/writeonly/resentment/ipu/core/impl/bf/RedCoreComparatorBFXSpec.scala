package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RedCoreComparatorBFXSpec extends RedCoreComparatorBFSpec {

  "bool" >> {
    "rmovi rnot" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rnot(d1)
      }
    }.setGens(value, address)

    "rmovi rtau" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rtau(d1)
      }
    }.setGens(value, address)

    "rmovi rclr" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rclr(d1)
      }
    }.setGens(value, address)

    "rmovi rset" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rset(d1)
      }
    }.setGens(value, address)
  }

  "eq" >> {
    "rmovi rmovi req" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.req(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi req" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.req(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi reqc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.reqc(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi reqc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.reqc(d1, d1)
      }
    }.setGens(value, address)

    "rmovi reqi" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.reqi(v2, d1)
      }
    }.setGens(value, value, address)
  }
  "ne" >> {
    "rmovi rmovi rne" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rne(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rne" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rne(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi rnec" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rnec(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rnec" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rnec(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rnei" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rnei(v2, d1)
      }
    }.setGens(value, value, address)
  }
  "le" >> {
    "rmovi rmovi rle" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rle(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rle" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rle(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi rlec" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rlec(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rlec" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rlec(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rlei" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rlei(v2, d1)
      }
    }.setGens(value, value, address)
  }
  "lt" >> {
    "rmovi rmovi rlt" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rlt(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rlt" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rlt(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi rltc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rltc(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rltc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rltc(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rlti" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rlti(v2, d1)
      }
    }.setGens(value, value, address)
  }
  "and" >> {
    "rmovi rmovi rand" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rand(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rand" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rand(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi randc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.randc(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi randc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.randc(d1, d1)
      }
    }.setGens(value, address)

    "rmovi randi" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.randi(v2, d1)
      }
    }.setGens(value, value, address)
  }
  "or" >> {
    "rmovi rmovi ror" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.ror(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi ror" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.ror(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rmovi rorc" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rmovi(v2, d2)
        c.rorc(d1, d2)
      }
    }.setGens(value, value, address, address)

    "rmovi rorc" >> prop { (v1: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rorc(d1, d1)
      }
    }.setGens(value, address)

    "rmovi rori" >> prop { (v1: Int, v2: Int, d1: Int) =>
      val comparator = new ComplexCoreComparatorBF
      comparator { c =>
        c.rmovi(v1, d1)
        c.rori(v2, d1)
      }
    }.setGens(value, value, address)
  }
}
