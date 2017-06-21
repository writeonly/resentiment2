package io.github.writeonly.resentiment.teapot.stack

import scala.collection.mutable

class InstructionsFake extends Instructions {

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


  override def ld(operand: Symbol): Unit = ld(m(b(operand)))

  override def ld(operand: Byte): Unit = m(p) = operand

  override def ld(operand: Int): Unit = ld(operand.asInstanceOf[Byte])

  override def ld(operand: Long): Unit = ld(operand.asInstanceOf[Int])


  override def st(operand: Symbol): Unit = m(b(operand)) = m(p)

  override def push: Unit = p +=1

  override def add: Unit = i((t1, t0) => t1 + t0)

  override def sub: Unit = i((t1, t0) => t1 - t0)

  override def neg: Unit = i(t0 => -t0)

  override def ng1: Unit = ???

  override def mul: Unit = i((t1, t0) => t1 * t0)

  override def div: Unit = i((t1, t0) => t1 / t0)

  override def mod: Unit = i((t1, t0) => t1 % t0)

  override def and: Unit = b((t1,t0) => c(t1 & t0))

  override def or: Unit = b((t1,t0) => c(t1 | t0))

  override def not: Unit = ???

  override def eq: Unit = b((t1,t0) => (t1 == t0))

  override def nq: Unit = b((t1,t0) => (t1 != t0))

  override def ls: Unit = b((t1,t0) => (t1 < t0))

  override def le: Unit = b((t1,t0) => (t1 <= t0))
}
