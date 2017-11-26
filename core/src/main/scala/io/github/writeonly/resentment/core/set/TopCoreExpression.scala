package io.github.writeonly.resentment.core.set

trait TopCoreExpression {
  def uadd(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def usub(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression

  def umul(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def udiv(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def umod(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression

  def ueq(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def une(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression

  def uand(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def uor(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  
  def ult(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def ugt(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression

  def ule(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
  def uge(o: TopCoreExpression => TopCoreExpression) : TopCoreExpression
}
