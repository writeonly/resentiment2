package io.github.writeonly.resentiment.teapot.core

import scala.collection.mutable

class InstructionsInterpreter extends Instructions {

  val m = new mutable.HashMap[Symbol, Int]()

  var a = 0

  def get(operand: Symbol):Int = m.get(operand).getOrElse(0)

  override def ld(operand: Symbol): Unit = ld(get(operand))

  override def ld(operand: Int): Unit = a = operand

  override def st(operand: Symbol): Unit = m.put(operand, a)

  override def add(operand: Symbol): Unit = add(get(operand))

  override def add(operand: Int): Unit = a += operand

  override def sub(operand: Symbol): Unit = sub(get(operand))

  override def sub(operand: Int): Unit = a -= operand
}
