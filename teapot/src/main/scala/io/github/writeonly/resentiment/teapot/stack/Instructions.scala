package io.github.writeonly.resentiment.teapot.stack

trait Instructions {
  def ld(operand :Symbol) : Unit
  def ld(operand :Int) : Unit
  def ld(operand :Byte) : Unit
  def ld(operand :Long) : Unit
  def st(operand :Symbol) : Unit
  def push : Unit

  def add : Unit
  def sub : Unit
  def neg : Unit
  def ng1 : Unit

  def mul : Unit
  def div : Unit
  def mod : Unit

  def and : Unit
  def or : Unit
  def not : Unit

  def eq : Unit
  def nq : Unit
  def ls : Unit
  def le : Unit


}
