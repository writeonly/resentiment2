package io.github.writeonly.resentment.ipu.core.impl.bf

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.AroundTimeout

@RunWith(classOf[JUnitRunner])
class RedCoreBFUnsafeSpec extends org.specs2.mutable.Specification
  with AroundTimeout {
  "this is my specification" >> {

    "greater equals 1" >> {
      val out = new OrtoBF().ge1(0)()
      out must_== "<<[<-]<[>>>-<[-]<<-<]>+>"
    }

    "greater equals 2" >> {
      val out = new OrtoBF().ge2(0)()
      out must_== "<<-[<-]<[>>>-<[-]+<<-<]>+>"
    }

    "greater equals 3" >> {
      val out = new OrtoBF().ge3(0)()
      out must_== "<[<-[<-]<[>>>-<[-]+<<-<]>+>>-]"
    }

    "greater that 1" >> {
      val out = new OrtoBF().gt1(0)()
      out must_== "<<[<-]<[>>>+<[-]<<-<]>+>"
    }

    "greater that 2" >> {
      val out = new OrtoBF().gt2(0)()
      out must_== "<<-[<-]<[>>>+<[-]+<<-<]>+>"
    }

    "greater that 3" >> {
      val out = new OrtoBF().gt3(0)()
      out must_== "<[<-[<-]<[>>>+<[-]+<<-<]>+>>-]"
    }

  }
}
