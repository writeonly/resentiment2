package io.github.writeonly.resentment.ipu.core.impl.bf

import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.execute._
import org.specs2.specification.AroundTimeout

abstract class RedCoreComparatorBFSpec
    extends org.specs2.mutable.Specification
    with AroundTimeout
    with ScalaCheck {

  implicit def unitAsResult: AsResult[Unit] = new AsResult[Unit] {
    def asResult(u: => Unit): Result = {
      u
      Success()
    }
  }

  val value = Gen.choose(0, 256)
  val valueNonZero = Gen.choose(1, 255)
  val valueNonNeg = Gen.choose(0, 126)
  val shortValuePos = Gen.choose(1, 4)
  val address = Gen.choose(1, 256)
  val shortAddress = Gen.choose(1, 4)

}
