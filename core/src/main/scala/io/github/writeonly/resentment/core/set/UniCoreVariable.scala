package io.github.writeonly.resentment.core.set

trait UniCoreVariable[C] {
  def ust(s :Symbol) : C
  def uld(s :Symbol) : C
  def uld(c :Int) : C
//  def uld(c :BigInt)
//  def uld(c :String)
}
