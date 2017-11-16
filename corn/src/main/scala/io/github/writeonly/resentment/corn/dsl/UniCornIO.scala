package io.github.writeonly.resentment.corn.dsl

trait UniCornIO[C] {
  def ust (s : Symbol) :C
  def uld (s : Symbol) :C
  def uld (c : Int) :C
}
