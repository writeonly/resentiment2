package io.github.writeonly.resentment.core.impl.fake

import io.github.writeonly.resentment.core.api.TopCore
import io.github.writeonly.resentment.core.set.TopCoreExpression

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

  override def uadd(o: Load => TopCoreExpression) = ???

  override def usub(o: Load => TopCoreExpression) = ???

  override def umul(o: Load => TopCoreExpression) = ???

  override def udiv(o: Load => TopCoreExpression) = ???

  override def umod(o: Load => TopCoreExpression) = ???

  override def ueq(o: Load => TopCoreExpression) = ???

  override def une(o: Load => TopCoreExpression) = ???

  override def uand(o: Load => TopCoreExpression) = ???

  override def uor(o: Load => TopCoreExpression) = ???

  override def ult(o: Load => TopCoreExpression) = ???

  override def ugt(o: Load => TopCoreExpression) = ???

  override def ule(o: Load => TopCoreExpression) = ???

  override def uge(o: Load => TopCoreExpression) = ???
}
