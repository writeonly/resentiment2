package io.github.writeonly.resentment.core.impl

import scala.collection.mutable

class CommonCorePopFake extends CommonCoreFake {

  val m = new mutable.HashMap[Int, Int]()
  var p = 0

  def get(symbol: Symbol) = b.get(symbol).get

  override def uvar(o: Symbol) = {
    b.put(o, p)
    p += 1
    ust(o)
  }

  override def ust(symbol:Symbol) = m.put(get(symbol), a)
  override def uld(o:Symbol) = a =  m.get(get(o)).get
  override def uld(o: Int) = ???
  def uld(o:Char) = a = o.toInt
  def uld(o:String) = a =  o.toInt

  override def pout() = out.append(a.toChar)
  override def pin() = ???

  override def pnot() = ???
  override def pneg() = ???
  override def png1() = ???
}
