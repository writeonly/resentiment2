package io.github.writeonly.resentment.core.impl.fake

import io.github.writeonly.resentment.api.StreamIO
import io.github.writeonly.resentment.core.api.UniCore

class UniCoreStackFake(val io: StreamIO) extends Fake with UniCore[Unit] {

  override def uvar(o: Symbol) = {
    symbols.put(o, topPointer)
    topPointer += 1
    ust(o)
  }

  override def ust(o: Symbol) = memory(pointer(o)) = accumulator.asInstanceOf[Byte]

  override def uld(o: Symbol) = accumulator = memory(pointer(o))

  override def uld(o: Int) = ???

  def uld(o: Char) = accumulator = o.toInt

  def uld(o: String) = accumulator = o.toInt

  override def pout() = io.out.write(accumulator)

  override def pin() = ???

  override def pnot() = ???

  override def pneg() = ???

  override def png1() = ???

  override def uadd(o: Int) = ???

  override def uadd(o: Symbol) = ???

  override def usub(o: Int) = ???

  override def usub(o: Symbol) = ???

  override def umul(o: Int) = ???

  override def umul(o: Symbol) = ???

  override def udiv(o: Int) = ???

  override def udiv(o: Symbol) = ???

  override def umod(o: Int) = ???

  override def umod(o: Symbol) = ???

  override def ueq(o: Symbol) = ???

  override def ueq(o: Int) = ???

  override def une(o: Symbol) = ???

  override def une(o: Int) = ???

  override def uand(o: Symbol) = ???

  override def uand(o: Int) = ???

  override def uor(o: Symbol) = ???

  override def uor(o: Int) = ???

  override def ult(o: Symbol) = ???

  override def ult(o: Int) = ???

  override def ugt(o: Symbol) = ???

  override def ugt(o: Int) = ???

  override def ule(o: Symbol) = ???

  override def ule(o: Int) = ???

  override def uge(o: Symbol) = ???

  override def uge(o: Int) = ???
}
