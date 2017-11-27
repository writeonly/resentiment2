package io.github.writeonly.resentment.core.set

trait UniCoreVariable[C] extends UniCoreLoad[C] {
  def uvar(o :Symbol) : C
  def ust(o :Symbol) : C
}
