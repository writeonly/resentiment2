package io.github.writeonly.resentment.core.set


trait TopCoreExpression {
  type Load = UniCoreLoad[_ <: TopCoreExpression]

  def uadd(o: Load => TopCoreExpression): TopCoreExpression

  def usub(o: Load => TopCoreExpression): TopCoreExpression

  def umul(o: Load => TopCoreExpression): TopCoreExpression

  def udiv(o: Load => TopCoreExpression): TopCoreExpression

  def umod(o: Load => TopCoreExpression): TopCoreExpression

  def ueq(o: Load => TopCoreExpression): TopCoreExpression

  def une(o: Load => TopCoreExpression): TopCoreExpression

  def uand(o: Load => TopCoreExpression): TopCoreExpression

  def uor(o: Load => TopCoreExpression): TopCoreExpression

  def ult(o: Load => TopCoreExpression): TopCoreExpression

  def ugt(o: Load => TopCoreExpression): TopCoreExpression

  def ule(o: Load => TopCoreExpression): TopCoreExpression

  def uge(o: Load => TopCoreExpression): TopCoreExpression
}
