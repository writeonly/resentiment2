package io.github.writeonly.resentment.fsm.impl

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class JumpTableCreatorSpec extends org.specs2.mutable.Specification {
  "this is my specification" >> {
    "where code []" >> {
      new JumpTableCreator("[]")() must_== Map(0 -> 1, 1 -> 0)
    }
    "where code [[]]" >> {
      new JumpTableCreator("[[]]")() must_== Map(2 -> 1, 1 -> 2, 3 -> 0, 0 -> 3)
    }
    "where code [[]][]" >> {
      new JumpTableCreator("[[]][]")() must_== Map(0 -> 3,
                                                   5 -> 4,
                                                   1 -> 2,
                                                   2 -> 1,
                                                   3 -> 0,
                                                   4 -> 5)
    }
    "where code [][[]]" >> {
      new JumpTableCreator("[][[]]")() must_== Map(0 -> 1,
                                                   5 -> 2,
                                                   1 -> 0,
                                                   2 -> 5,
                                                   3 -> 4,
                                                   4 -> 3)
    }
    "where code ][" >> {
      new JumpTableCreator("][")() must throwA[IllegalStateException]
    }
  }
}
