package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class OrtoBFSpec
    extends org.specs2.mutable.Specification
    with AroundTimeout
    with ScalaCheck {

  val value = Gen.choose(0, 256)
  val valueNonZero = Gen.choose(1, 255)
  val valueNonNeg = Gen.choose(0, 126)
  val shortValuePos = Gen.choose(1, 4)
  val address = Gen.choose(1, 256)
  val shortAddress = Gen.choose(1, 4)

  "div vs divmod" >> {
    "rmovi rmovi rdiv" >> prop { (v1: Int, v2: Int, d1: Int, d2: Int) =>
      val div = new OrtoBF()
      val fdiv = div.mkm(
        div.mov.im(v1, d1),
        div.mov.im(v2, d2),
        div.div.dir(d1, d2)
      )
      val divmod = new OrtoBF()
      val fdivmod = divmod.mkm(
        divmod.mov.im(v1, d1),
        divmod.mov.im(v2, d2),
        divmod.divmod.dir(d1, d2)
      )
      new FInterpreterBF()
        .apply(fdiv().toString().getBytes())
        .memory(d1) must_== new FInterpreterBF()
        .apply(fdivmod().toString().getBytes())
        .memory(d1)
    }.setGens(value, value, address, address)
  }

  "this is my specification" >> {

    "greater equals 1" >> {
      val out = new OrtoBF().lle.ge1(0)()
      out must_== "<<[<-]<[>>>-<[-]<<-<]>+>"
    }

    "greater equals 2" >> {
      val out = new OrtoBF().lle.ge2(0)()
      out must_== "<<-[<-]<[>>>-<[-]+<<-<]>+>"
    }

    "greater equals 3" >> {
      val out = new OrtoBF().lle.ge3(0)()
      out must_== "<[<-[<-]<[>>>-<[-]+<<-<]>+>>-]"
    }

    "greater that 1" >> {
      val out = new OrtoBF().llt.gt1(0)()
      out must_== "<<[<-]<[>>>+<[-]<<-<]>+>"
    }

    "greater that 2" >> {
      val out = new OrtoBF().llt.gt2(0)()
      out must_== "<<-[<-]<[>>>+<[-]+<<-<]>+>"
    }

    "greater that 3" >> {
      val out = new OrtoBF().llt.gt3(0)()
      out must_== "<[<-[<-]<[>>>+<[-]+<<-<]>+>>-]"
    }

  }
}
