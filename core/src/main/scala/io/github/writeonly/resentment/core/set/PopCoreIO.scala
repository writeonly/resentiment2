package io.github.writeonly.resentment.core.set

trait PopCoreIO[C] {
  def in() : C
  def out() : C
}
