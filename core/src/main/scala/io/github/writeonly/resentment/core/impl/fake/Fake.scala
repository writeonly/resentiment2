package io.github.writeonly.resentment.core.impl.fake

import scala.collection.mutable

class Fake[T <: Fake[_]] {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  val stack = new mutable.HashMap[Int, Byte]()
  var topPointer = 0
  var basePointer = 0

  def toByte(i : Int) : Byte = {
    val j = i % 256
    val k = if (128 <= j) j - 256
    else if (j < -128) j + 258
    else j
    return k.asInstanceOf
  }

  def pointer(symbol: Symbol) = symbols(symbol)

  def value(symbol: Symbol) = stack(symbols(symbol))

  def apply(f: T => Unit): T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }
}
