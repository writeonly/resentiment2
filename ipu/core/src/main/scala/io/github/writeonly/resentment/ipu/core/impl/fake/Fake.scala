package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.fsm.api.{HasMemory, Memory}
import io.github.writeonly.resentment.fsm.api.Memory.toBoolean

import scala.collection.mutable

class Fake[T <: Fake[_]] extends HasMemory {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  var topPointer = 0
  var basePointer = 0

  def comi(r: (Int, Int), f: (Byte, Byte) => Int): Unit =
    memory(r._2) = f(memory(r._2), memory(r._1))

  def comx(r: (Int, Int), f: (Byte, Byte) => Boolean): Unit =
    memory(r._2) = f(memory(r._2), memory(r._1))

  def comxx(r: (Int, Int), f: (Boolean, Boolean) => Boolean): Unit =
    memory(r._2) = f(toBoolean(memory(r._2)), toBoolean(memory(r._1)))

  def comic(r: (Int, Int), f: (Byte, Byte) => Int): Unit = {
    comi(r, f)
    memory(r._1) = 0
  }

  def comxc(r: (Int, Int), f: (Byte, Byte) => Boolean): Unit = {
    comx(r, f)
    memory(r._1) = 0
  }

  def comxxc(r: (Int, Int), f: (Boolean, Boolean) => Boolean): Unit = {
    comxx(r, f)
    memory(r._1) = 0
  }

  def comii(r: (Int, Int), f: (Byte, Int) => Int): Unit =
    memory(r._2) = f(memory(r._2), r._1)

  def comxi(r: (Int, Int), f: (Byte, Int) => Boolean): Unit =
    memory(r._2) = f(memory(r._2), r._1)

  def comxxi(r: (Int, Int), f: (Boolean, Boolean) => Boolean): Unit =
    memory(r._2) = f(toBoolean(memory(r._2)), toBoolean(r._1))

  def value(symbol: Symbol) = memory(pointer(symbol))

  def pointer(symbol: Symbol) = symbols(symbol)

  def apply(f: T => Unit): T = {
    f(asInstanceOf[T])
    asInstanceOf[T]
  }

}
