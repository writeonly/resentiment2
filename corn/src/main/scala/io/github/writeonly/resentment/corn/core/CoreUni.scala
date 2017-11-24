package io.github.writeonly.resentment.corn.core

import io.github.writeonly.resentment.core.set.CommonCore

import scala.collection.mutable

class CoreUni extends CommonCore[Unit] {
  val b = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val out = new StringBuilder

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
