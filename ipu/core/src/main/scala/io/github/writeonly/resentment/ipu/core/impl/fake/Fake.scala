package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.fsm.api.{HasMemory, Memory}
import io.github.writeonly.resentment.fsm.api.Memory.toBoolean

import scala.collection.mutable

class Fake[T <: Fake[_]] extends HasMemory {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  var topPointer = 0
  var basePointer = 0

  def comi(s: Int, d: Int, f: (Byte, Byte) => Int): Unit = memory(d) = f(memory(d), memory(s))

  def comx(s: Int, d: Int, f: (Byte, Byte) => Boolean): Unit = memory(d) = f(memory(d), memory(s))

  def comxx(s: Int, d: Int, f: (Boolean, Boolean) => Boolean): Unit = memory(d) = f(toBoolean(memory(d)), toBoolean(memory(s)))

  def comic(s: Int, d: Int, f: (Byte, Byte) => Int): Unit = {
    comi(s, d, f)
    memory(s) = 0
  }

  def comxc(s: Int, d: Int, f: (Byte, Byte) => Boolean): Unit = {
    comx(s, d, f)
    memory(s) = 0
  }

  def comxxc(s: Int, d: Int, f: (Boolean, Boolean) => Boolean): Unit = {
    comxx(s, d, f)
    memory(s) = 0
  }

  def comii(s: Int, d: Int, f: (Byte, Int) => Int): Unit = memory(d) = f(memory(d), s)

  def comxi(s: Int, d: Int, f: (Byte, Int) => Boolean): Unit = memory(d) = f(memory(d), s)

  def comxxi(s: Int, d: Int, f: (Boolean, Boolean) => Boolean): Unit = memory(d) = f(toBoolean(memory(d)), toBoolean(s))

  def value(symbol: Symbol) = memory(pointer(symbol))

  def pointer(symbol: Symbol) = symbols(symbol)

  def apply(f: T => Unit): T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }

}
