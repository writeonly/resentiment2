package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.api.PopCore
import io.github.writeonly.resentment.core.pipe.StreamIO

class PopCoreFake(val io : StreamIO) extends Fake with PopCore[Unit] {

  def popi(f :(Byte,Byte) => Int):Unit = {
    stack(topPointer-1) = f(stack(topPointer-1), top).asInstanceOf[Byte]
    pop
  }

  def popb(f :(Byte,Byte) => Boolean):Unit = {
    stack(topPointer-1) = toInt(f(stack(topPointer-1), top))
    pop
  }

  def pop = {
    stack(topPointer) = 0
    topPointer -= 1
  }

  def top: Byte = stack(topPointer)

  def top(l :(Byte) => Int):Unit = stack(topPointer) = l(top).asInstanceOf[Byte]

  def toInt(b:Boolean) = (if (b) 1 else 0).asInstanceOf[Byte]

  def toBoolean(b:Integer):Boolean =  b != 0

  override def uvar(o: Symbol) = {
    symbols.put(o, basePointer)
    basePointer += 1
    ppush
//    ust(o)
  }

  override def ust(o: Symbol): Unit = stack(symbols(o)) = top
  override def uld(o: Symbol): Unit = uld(stack(symbols(o)))
  override def uld(o: Int) = stack(topPointer) = o.toByte
  override def uld(o: Char) = uld(o.toInt)
  override def uld(o: String) = uld(o.toInt)

  override def pin() = ???
  override def pout() = io.out.write(top)

  override def ppush: Unit = topPointer +=1

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
