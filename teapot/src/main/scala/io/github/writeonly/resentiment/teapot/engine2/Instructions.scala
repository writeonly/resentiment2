package io.github.writeonly.resentiment.teapot.engine2

trait Instructions {
  def uld(operand :Symbol) : Unit
  def uld(operand :Int) : Unit
  def ust(operand :Symbol) : Unit

  def uadd(operand :Symbol) : Unit
  def uadd(operand :Int) : Unit
  def usub(operand :Symbol) : Unit
  def usub(operand :Int) : Unit

  def umul(operand :Symbol) : Unit
  def umul(operand :Int) : Unit
  def udiv(operand :Symbol) : Unit
  def udiv(operand :Int) : Unit
  def umod(operand :Symbol) : Unit
  def mod(operand :Int) : Unit

  def pnot() : Unit
  def pneg() : Unit

  def ueq(operand :Symbol) : Unit
  def ueq(operand :Int) : Unit
  def une(operand :Symbol) : Unit
  def une(operand :Int) : Unit

  def uand(operand :Symbol) : Unit
  def uand(operand :Int) : Unit
  def uor(operand :Symbol) : Unit
  def uor(operand :Int) : Unit


  def ult(operand :Symbol) : Unit
  def ult(operand :Int) : Unit
  def ugt(operand :Symbol) : Unit
  def ugt(operand :Int) : Unit

  def ule(operand :Symbol) : Unit
  def ule(operand :Int) : Unit
  def uge(operand :Symbol) : Unit
  def uge(operand :Int) : Unit

}
