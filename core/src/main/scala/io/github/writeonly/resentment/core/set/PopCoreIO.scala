package io.github.writeonly.resentment.core.set

trait PopCoreIO[C] {
  def pin() : C
  def pout() : C
}
