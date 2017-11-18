package io.github.writeonly.resentment.core.set

trait PopCoreExpression[C] {
  def padd() : C
  def psub() : C
  def pmul() : C
  def pdiv() : C
  def pmod() : C
}
