package io.github.writeonly.resentment.core.impl

import scala.collection.mutable

class Fake[T<:Fake[_]] {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  val stack = new mutable.HashMap[Int, Byte]()
  var topPointer = 0
  var basePointer = 0

  def pointer(symbol: Symbol) = symbols(symbol)

  def value(symbol:Symbol) = stack(symbols(symbol))

  def apply(f : T => Unit) : T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }
}
