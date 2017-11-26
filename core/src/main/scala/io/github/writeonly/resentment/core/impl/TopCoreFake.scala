package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.api.TopCore
import io.github.writeonly.resentment.core.set.TopCoreExpression

import scala.collection.mutable

class TopCoreFake extends Fake with TopCore[Unit] {

  override def uvar(s: Symbol) = ???
  override def ust(s: Symbol): Unit = ???

  override def uld(s: Symbol): Unit = ???
  override def uld(c: Int): Unit = ???
  override def uld(o: Char) = ???
  override def uld(o: String) = ???

  override def pin() = ???
  override def pout() = ???


  override def pnot() = ???
  override def pneg() = ???
  override def png1() = ???

  override def uadd(o: TopCoreExpression => TopCoreExpression) = ???

  override def usub(o: TopCoreExpression => TopCoreExpression) = ???

  override def umul(o: TopCoreExpression => TopCoreExpression) = ???

  override def udiv(o: TopCoreExpression => TopCoreExpression) = ???

  override def umod(o: TopCoreExpression => TopCoreExpression) = ???

  override def ueq(o: TopCoreExpression => TopCoreExpression) = ???

  override def une(o: TopCoreExpression => TopCoreExpression) = ???

  override def uand(o: TopCoreExpression => TopCoreExpression) = ???

  override def uor(o: TopCoreExpression => TopCoreExpression) = ???

  override def ult(o: TopCoreExpression => TopCoreExpression) = ???

  override def ugt(o: TopCoreExpression => TopCoreExpression) = ???

  override def ule(o: TopCoreExpression => TopCoreExpression) = ???

  override def uge(o: TopCoreExpression => TopCoreExpression) = ???
}
