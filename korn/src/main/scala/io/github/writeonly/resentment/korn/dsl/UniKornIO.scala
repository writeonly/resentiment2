package io.github.writeonly.resentment.korn.dsl

trait UniKornIO[K] {
  def ust (s : Symbol) :K
  def uld (s : Symbol) :K
  def uld (c : Short) :K
}
