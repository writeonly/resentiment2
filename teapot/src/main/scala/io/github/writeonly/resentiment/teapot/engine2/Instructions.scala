package io.github.writeonly.resentiment.teapot.engine2

trait Instructions {
  def ld(operand :Symbol) : Unit
  def ld(operand :Int) : Unit
  def st(operand :Symbol) : Unit

  def add(operand :Symbol) : Unit
  def add(operand :Int) : Unit
  def sub(operand :Symbol) : Unit
  def sub(operand :Int) : Unit

  def mul(operand :Symbol) : Unit
  def mul(operand :Int) : Unit
  def div(operand :Symbol) : Unit
  def div(operand :Int) : Unit
  def mod(operand :Symbol) : Unit
  def mod(operand :Int) : Unit

  def not() : Unit
  def neg() : Unit

  def eq(operand :Symbol) : Unit
  def eq(operand :Int) : Unit
  def ne(operand :Symbol) : Unit
  def ne(operand :Int) : Unit

  def and(operand :Symbol) : Unit
  def and(operand :Int) : Unit
  def or(operand :Symbol) : Unit
  def or(operand :Int) : Unit


  def lt(operand :Symbol) : Unit
  def lt(operand :Int) : Unit
  def gt(operand :Symbol) : Unit
  def gt(operand :Int) : Unit

  def le(operand :Symbol) : Unit
  def le(operand :Int) : Unit
  def ge(operand :Symbol) : Unit
  def ge(operand :Int) : Unit

}
