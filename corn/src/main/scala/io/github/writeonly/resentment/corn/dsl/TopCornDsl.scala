package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.TopCore
import io.github.writeonly.resentment.core.set.TopCoreExpression

class TopCornDsl extends TopCore[TopCornDsl] {
  override def uvar(o: Symbol) = ???

  override def ust(o: Symbol) = ???

  override def uld(o: Symbol) = ???

  override def uld(o: Int) = ???

  override def uld(o: Char) = ???

  override def uld(o: String) = ???

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

  override def pin() = ???

  override def pout() = ???
}
