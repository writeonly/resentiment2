package io.github.writeonly.resentiment.teapot.core

import scala.collection.mutable

class InstructionsFake extends Instructions {

  val m = new mutable.HashMap[Symbol, Int]()

  var a = 0

  def get(operand: Symbol):Int = m.get(operand).getOrElse(0)

  def toInt(operand : Boolean) = if (operand) 1 else 0
  def toBoolean(operand: Int) = operand != 0
  def set(operand : Boolean) = a = toInt(operand)

  override def ld(operand: Symbol): Unit = ld(get(operand))
  override def ld(operand: Int): Unit = a = operand
  override def st(operand: Symbol): Unit = m.put(operand, a)

  override def add(operand: Symbol): Unit = add(get(operand))
  override def add(operand: Int): Unit = a += operand

  override def sub(operand: Symbol): Unit = sub(get(operand))
  override def sub(operand: Int): Unit = a -= operand
  override def neg() : Unit = a = -a

  override def mul(operand :Symbol) : Unit = mul(get(operand))
  override def mul(operand :Int) : Unit = a *= operand
  override def div(operand :Symbol) : Unit = div(get(operand))
  override def div(operand :Int) : Unit = a /= operand
  override def mod(operand :Symbol) : Unit = mod(get(operand))
  override def mod(operand :Int) : Unit = a %= operand

  override def and(operand :Symbol) : Unit = and(get(operand))
  override def and(operand :Int) : Unit = set(toBoolean(a) & toBoolean(operand))
  override def or(operand :Symbol) : Unit = or(get(operand))
  override def or(operand :Int) : Unit = set(toBoolean(a) | toBoolean(operand))

  override def not() : Unit = set(toBoolean(a))

  override def eq(operand :Symbol) : Unit = eq(get(operand))
  override def eq(operand :Int) : Unit = set(a == operand)
  override def ne(operand :Symbol) : Unit = ne(get(operand))
  override def ne(operand :Int) : Unit = set(a != operand)


  override def lt(operand :Symbol) : Unit = lt(get(operand))
  override def lt(operand :Int) : Unit = set(a < operand)
  override def gt(operand :Symbol) : Unit = gt(get(operand))
  override def gt(operand :Int) : Unit = set(a > operand)

  override def le(operand :Symbol) : Unit = le(get(operand))
  override def le(operand :Int) : Unit = set(a <= operand)
  override def ge(operand :Symbol) : Unit = ge(get(operand))
  override def ge(operand :Int) : Unit = set(a >= operand)
}
