package io.github.writeonly.resentment.ipu.core.set

trait UniCoreLoad[C] {
  def uld(o: Symbol): C

  def uld(o: Int): C

  def uld(o: Char): C

  def uld(o: String): C
}
