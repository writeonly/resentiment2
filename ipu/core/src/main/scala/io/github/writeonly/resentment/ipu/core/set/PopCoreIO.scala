package io.github.writeonly.resentment.ipu.core.set

trait PopCoreIO[C] {
  def pin(): C

  def pout(): C
}
