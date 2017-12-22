package io.github.writeonly.resentment.core.impl.fake

import scala.collection.mutable

class Fake[T <: Fake[_]] {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  val memory = new mutable.HashMap[Int, Byte]() {
    override def apply(k : Int) : Byte = get(k).getOrElse(0)
  }
  var topPointer = 0
  var basePointer = 0

  def toByte(i : Int) : Byte = {
    val j = i % 256
    val k = if (128 <= j) j - 256
    else if (j < -128) j + 258
    else j
    k.asInstanceOf[Byte]
  }

  def toBoolean(b: Int): Boolean = b != 0

  def toBoolean(b: Byte): Boolean = b != 0

  def toByte(b: Boolean) = toInt(b).asInstanceOf[Byte]

  def toInt(o: Boolean) = if (o) 1 else 0

  def pointer(symbol: Symbol) = symbols(symbol)

  def value(symbol: Symbol) = memory(symbols(symbol))

  def apply(f: T => Unit): T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }
}