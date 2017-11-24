package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.api.StackCore
import io.github.writeonly.resentment.core.pipe.StreamIO

import scala.collection.mutable

class StackCoreFake(val io : StreamIO) extends StackCore[Unit] {

  val m = new mutable.MutableList[Byte]

  val b = new mutable.HashMap[Symbol, Int]

  var p = 0

  def popi(f :(Byte,Byte) => Int):Unit = {
    m(p-1) = f(m(p-1), top).asInstanceOf[Byte]
    pop
  }

  def popb(f :(Byte,Byte) => Boolean):Unit = {
    m(p-1) = toInt(f(m(p-1), top))
    pop
  }

  def pop = {
    m(p) = 0
    p -= 1
  }

  def top(l :(Byte) => Int):Unit = m(p) = l(m(p)).asInstanceOf[Byte]

  def toInt(b:Boolean) = (if (b) 1 else 0).asInstanceOf[Byte]

  def toBoolean(b:Integer):Boolean =  b != 0

  def top: Byte = m(p)

  override def uvar(o: Symbol) = ust(o)
  override def ust(o: Symbol): Unit = m(b(o)) = m(p)
  override def uld(o: Symbol): Unit = uld(m(b(o)))
  override def uld(c: Int) = ???
  override def uld(o: Char) = ???
  override def uld(o: String) = ???

  override def pin() = ???
  override def pout() = {io.out.write(top); pop}

  override def ppush: Unit = p +=1

  override def ppop() = ???

  override def padd: Unit = popi((t1, t0) => t1 + t0)

  override def psub: Unit = popi((t1, t0) => t1 - t0)

  override def pneg: Unit = top(t0 => -t0)

  override def png1: Unit = ???

  override def pmul: Unit = popi((t1, t0) => t1 * t0)

  override def pdiv: Unit = popi((t1, t0) => t1 / t0)

  override def pmod: Unit = popi((t1, t0) => t1 % t0)

  override def pand: Unit = popb((t1, t0) => toBoolean(t1 & t0))

  override def por: Unit = popb((t1, t0) => toBoolean(t1 | t0))

  override def pnot: Unit = ???

  override def peq: Unit = popb((t1, t0) => (t1 == t0))

  override def pne: Unit = popb((t1, t0) => (t1 != t0))

  override def plt: Unit = popb((t1, t0) => (t1 < t0))

  override def ple: Unit = popb((t1, t0) => (t1 <= t0))

  override def pgt: Unit = popb((t1, t0) => (t1 < t0))

  override def pge: Unit = popb((t1, t0) => (t1 <= t0))

}
