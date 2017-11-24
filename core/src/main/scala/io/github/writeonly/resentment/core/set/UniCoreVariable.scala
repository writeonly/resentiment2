package io.github.writeonly.resentment.core.set

trait UniCoreVariable[C] {
  def uvar(o :Symbol) : C
  def ust(o :Symbol) : C
  def uld(o :Symbol) : C
  def uld(o :Int) : C
  def uld(o :Char) : C
  def uld(o :String) : C
}
