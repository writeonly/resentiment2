package io.github.writeonly.resentment.corn.dsl

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TSpecification {
  class TSpecification extends org.specs2.mutable.Specification {
    "this is my specification" >> {
      "where example 1 must be true" >> {
        1 must_== 1
      }
      "where example 2 must be true" >> {
        2 must_== 2
      }
    }
  }
}
