package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.pipe.StreamIO

class CommonCoreUniFake(io : StreamIO) extends CommonCoreFake(io) {

  override def uvar(o:Symbol) = b.put(o, a)
  override def ust(o:Symbol) = b.put(o, a)

  override def uld(o:Symbol) =  a = b(o)
  override def uld(o: Int) = ???
  def uld(o:Char) = a = o.toInt
  def uld(o:String) = a =  o.toInt

  override def pout() = io.out.write(a)
  override def pin() = ???

  override def pnot() = ???
  override def pneg() = ???
  override def png1() = ???

}
