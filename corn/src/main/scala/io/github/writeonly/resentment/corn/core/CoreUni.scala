package io.github.writeonly.resentment.corn.core

class CoreUni extends Core {

  override def uvar(o:Symbol) = b.put(o, a)
  override def ust(o:Symbol) = b.put(o, a)

  override def uld(o:Symbol) =  a = b(o)
  override def uld(o: Int) = ???
  def uld(o:Char) = a = o.toInt
  def uld(o:String) = a =  o.toInt
  def uld(o:BigDecimal) = a = o.bigDecimal.toBigInteger.intValue()

  override def pout() = out.append(a.toChar)
  override def pin() = ???

  override def pnot() = ???
  override def pneg() = ???
  override def png1() = ???

}
