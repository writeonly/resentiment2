package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.api.StackCore

import scala.collection.mutable

class StackCoreFake extends StackCore[Unit] {


  val m = new mutable.MutableList[Byte]

  val b = new mutable.HashMap[Symbol, Int]

  var p = 0

  def i(l :(Byte,Byte) => Int):Unit = {
    m(p-1) = l(m(p-1), m(p)).asInstanceOf[Byte]
    m(p) = 0;
    p -= 1
  }

  def b(l :(Byte,Byte) => Boolean):Unit = {
    m(p-1) = c(l(m(p-1), m(p)))
    m(p) = 0
    p -= 1
  }

  def i(l :(Byte) => Int):Unit = m(p) = l(m(p)).asInstanceOf[Byte]

  def c(b:Boolean) = (if (b) 1 else 0).asInstanceOf[Byte]

  def c(b:Integer) =  b != 0



  override def uvar(o: Symbol) = ust(o)
  override def ust(o: Symbol): Unit = m(b(o)) = m(p)
  override def uld(o: Symbol): Unit = uld(m(b(o)))
  override def uld(c: Int) = ???
  override def uld(o: Char) = ???
  override def uld(o: String) = ???

  override def pin() = ???
  override def pout() = ???

  override def ppush: Unit = p +=1

  override def ppop() = ???

  override def padd: Unit = i((t1, t0) => t1 + t0)

  override def psub: Unit = i((t1, t0) => t1 - t0)

  override def pneg: Unit = i(t0 => -t0)

  override def png1: Unit = ???

  override def pmul: Unit = i((t1, t0) => t1 * t0)

  override def pdiv: Unit = i((t1, t0) => t1 / t0)

  override def pmod: Unit = i((t1, t0) => t1 % t0)

  override def pand: Unit = b((t1, t0) => c(t1 & t0))

  override def por: Unit = b((t1, t0) => c(t1 | t0))

  override def pnot: Unit = ???

  override def peq: Unit = b((t1, t0) => (t1 == t0))

  override def pne: Unit = b((t1, t0) => (t1 != t0))

  override def plt: Unit = b((t1, t0) => (t1 < t0))

  override def ple: Unit = b((t1, t0) => (t1 <= t0))

  override def pgt: Unit = b((t1, t0) => (t1 < t0))

  override def pge: Unit = b((t1, t0) => (t1 <= t0))

}
