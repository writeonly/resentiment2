package io.github.writeonly.resentment.core.set

trait UniCoreExpression[C] {
  def uadd(o:Int) : C
  def uadd(o:Symbol) : C
  def usub(o:Int) : C
  def usub(o:Symbol) : C
  
  def umul(o:Int) : C
  def umul(o:Symbol) : C
  def udiv(o:Int) : C
  def udiv(o:Symbol) : C
  def umod(o:Int) : C
  def umod(o:Symbol) : C

  def ueq(o:Symbol) : C
  def ueq(o:Int) : C
  def une(o:Symbol) : C
  def une(o:Int) : C

  def uand(o:Symbol) : C
  def uand(o:Int) : C
  def uor(o:Symbol) : C
  def uor(o:Int) : C


  def ult(o:Symbol) : C
  def ult(o:Int) : C
  def ugt(o:Symbol) : C
  def ugt(o:Int) : C

  def ule(o:Symbol) : C
  def ule(o:Int) : C
  def uge(o:Symbol) : C
  def uge(o:Int) : C
  
}
