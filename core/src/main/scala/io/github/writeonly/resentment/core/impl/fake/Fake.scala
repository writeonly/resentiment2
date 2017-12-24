package io.github.writeonly.resentment.core.impl.fake

import io.github.writeonly.resentment.api.Interpreter

import scala.collection.mutable

class Fake[T <: Fake[_]] extends Interpreter {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  var topPointer = 0
  var basePointer = 0

  def comi(s: Int, d: Int, f: (Byte, Byte) => Int): Unit = memory(d) = f(memory(d), memory(s))

  def comx(s: Int, d: Int, f: (Byte, Byte) => Boolean): Unit = memory(d) = f(memory(d), memory(s))

  def pointer(symbol: Symbol) = symbols(symbol)

  def value(symbol: Symbol) = memory(symbols(symbol))

  def apply(f: T => Unit): T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }

  override def apply() = ???
}
