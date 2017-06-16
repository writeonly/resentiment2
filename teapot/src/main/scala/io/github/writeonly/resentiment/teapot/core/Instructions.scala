package io.github.writeonly.resentiment.teapot.core

trait Instructions {
  def ld(operand :Symbol) : Unit
  def ld(operand :Int) : Unit
  def st(operand :Symbol) : Unit

  def add(operand :Symbol) : Unit
  def add(operand :Int) : Unit
  def sub(operand :Symbol) : Unit
  def sub(operand :Int) : Unit
}
