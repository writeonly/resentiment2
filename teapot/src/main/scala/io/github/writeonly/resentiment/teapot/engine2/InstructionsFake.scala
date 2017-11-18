package io.github.writeonly.resentiment.teapot.engine2

import io.github.writeonly.resentment.core.api.UniCore

import scala.collection.mutable

class InstructionsFake extends UniCore {

  val m = new mutable.HashMap[Symbol, Int]()

  var a = 0

  def get(operand: Symbol):Int = m.get(operand).getOrElse(0)

  def toInt(operand : Boolean) = if (operand) 1 else 0
  def toBoolean(operand: Int) = operand != 0
  def set(operand : Boolean) = a = toInt(operand)

  override def uld(operand: Symbol): Unit = uld(get(operand))
  override def uld(operand: Int): Unit = a = operand
  override def ust(operand: Symbol): Unit = m.put(operand, a)

  override def uadd(operand: Symbol): Unit = uadd(get(operand))
  override def uadd(operand: Int): Unit = a += operand

  override def usub(operand: Symbol): Unit = usub(get(operand))
  override def usub(operand: Int): Unit = a -= operand
  override def pneg() : Unit = a = -a

  override def umul(operand :Symbol) : Unit = umul(get(operand))
  override def umul(operand :Int) : Unit = a *= operand
  override def udiv(operand :Symbol) : Unit = udiv(get(operand))
  override def udiv(operand :Int) : Unit = a /= operand
  override def umod(operand :Symbol) : Unit = umod(get(operand))
  override def umod(operand :Int) : Unit = a %= operand

  override def uand(operand :Symbol) : Unit = uand(get(operand))
  override def uand(operand :Int) : Unit = set(toBoolean(a) & toBoolean(operand))
  override def uor(operand :Symbol) : Unit = uor(get(operand))
  override def uor(operand :Int) : Unit = set(toBoolean(a) | toBoolean(operand))

  override def pnot() : Unit = set(toBoolean(a))

  override def ueq(operand :Symbol) : Unit = ueq(get(operand))
  override def ueq(operand :Int) : Unit = set(a == operand)
  override def une(operand :Symbol) : Unit = une(get(operand))
  override def une(operand :Int) : Unit = set(a != operand)


  override def ult(operand :Symbol) : Unit = ult(get(operand))
  override def ult(operand :Int) : Unit = set(a < operand)
  override def ugt(operand :Symbol) : Unit = ugt(get(operand))
  override def ugt(operand :Int) : Unit = set(a > operand)

  override def ule(operand :Symbol) : Unit = ule(get(operand))
  override def ule(operand :Int) : Unit = set(a <= operand)
  override def uge(operand :Symbol) : Unit = uge(get(operand))
  override def uge(operand :Int) : Unit = set(a >= operand)
}
