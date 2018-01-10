package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.fsm.api.{HasMemory, Interpreter}

import scala.collection.mutable

class Fake[T <: Fake[_]] extends HasMemory {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  var topPointer = 0
  var basePointer = 0

  def comi(s: Int, d: Int, f: (Byte, Byte) => Int): Unit = memory(d) = f(memory(d), memory(s))

  def comx(s: Int, d: Int, f: (Byte, Byte) => Boolean): Unit = memory(d) = f(memory(d), memory(s))

  def comic(s: Int, d: Int, f: (Byte, Byte) => Int): Unit = {
    memory(d) = f(memory(d), memory(s))
    memory(s) = 0
  }

  def comxc(s: Int, d: Int, f: (Byte, Byte) => Boolean): Unit = {
    memory(d) = f(memory(d), memory(s))
    memory(s) = 0
  }

  def comii(s: Int, d: Int, f: (Byte, Int) => Int): Unit = memory(d) = f(memory(d), s)

  def comix(s: Int, d: Int, f: (Byte, Int) => Boolean): Unit = memory(d) = f(memory(d), s)


  def pointer(symbol: Symbol) = symbols(symbol)

  def value(symbol: Symbol) = memory(pointer(symbol))

  def apply(f: T => Unit): T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }

}
