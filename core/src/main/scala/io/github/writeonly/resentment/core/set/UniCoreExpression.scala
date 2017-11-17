package io.github.writeonly.resentment.core.set

trait UniCoreExpression {
  def uadd(o:Int) : Unit
  def uadd(o:Symbol) : Unit
  def usub(o:Int) : Unit
  def usub(o:Symbol) : Unit
  
  def umul(o:Int) : Unit
  def umul(o:Symbol) : Unit
  def udiv(o:Int) : Unit
  def udiv(o:Symbol) : Unit
  def umod(o:Int) : Unit
  def umod(o:Symbol) : Unit

  def ueq(o:Symbol) : Unit
  def ueq(o:Int) : Unit
  def une(o:Symbol) : Unit
  def une(o:Int) : Unit

  def uand(o:Symbol) : Unit
  def uand(o:Int) : Unit
  def uor(o:Symbol) : Unit
  def uor(o:Int) : Unit


  def ult(o:Symbol) : Unit
  def ult(o:Int) : Unit
  def ugt(o:Symbol) : Unit
  def ugt(o:Int) : Unit

  def ule(o:Symbol) : Unit
  def ule(o:Int) : Unit
  def uge(o:Symbol) : Unit
  def uge(o:Int) : Unit
  
}
