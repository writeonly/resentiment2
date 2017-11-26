package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.core.set.CommonCore

class UniCore2Fake(val io : StreamIO) extends Fake with CommonCore[Unit]  {
  
  override def uvar(o: Symbol) = {
    symbols.put(o, topPointer)
    topPointer += 1
    ust(o)
  }

  override def ust(o:Symbol) = stack(get(o)) =  accumulator.asInstanceOf[Byte]
  override def uld(o:Symbol) = accumulator =  stack.get(get(o)).get
  override def uld(o: Int) = ???
  def uld(o:Char) = accumulator = o.toInt
  def uld(o:String) = accumulator =  o.toInt

  override def pout() = io.out.write(accumulator)
  override def pin() = ???

  override def pnot() = ???
  override def pneg() = ???
  override def png1() = ???
}
