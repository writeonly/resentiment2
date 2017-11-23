package io.github.writeonly.resentment.core.set

trait UniCoreVariable[C] {
  def uvar(o :Symbol) : C
  def ust(o :Symbol) : C
  def uld(o :Symbol) : C
  def uld(o :Int) : C
//  def uld(c :BigInt)
//  def uld(c :String)
}
