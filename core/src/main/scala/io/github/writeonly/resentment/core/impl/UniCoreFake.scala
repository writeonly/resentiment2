package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.api.UniCore
import io.github.writeonly.resentment.core.pipe.StreamIO

import scala.collection.mutable

class UniCoreFake(val io : StreamIO) extends Fake with UniCore[Unit] {

  private def toInt(o : Boolean) = if (o) 1 else 0
  private def toBoolean(o: Int) = o != 0
  private def set(o : Boolean) = accumulator = toInt(o)

  override def uvar(o: Symbol) = ust(o)
  override def ust(o: Symbol): Unit = symbols(o) = accumulator

  override def uld(o: Symbol): Unit = accumulator = get(o)

  override def uld(c: Int): Unit = accumulator = c
  override def uld(o: Char) = accumulator = o
  override def uld(o: String) = accumulator = o.toInt

  override def pin() = accumulator = io.in.read()
  override def pout() = io.out.write(accumulator)

  override def uadd(o: Symbol): Unit = uadd(get(o))
  override def uadd(o: Int): Unit = accumulator += o
  override def usub(o: Symbol): Unit = usub(get(o))
  override def usub(o: Int): Unit = accumulator -= o
  override def umul(o: Symbol): Unit = umul(get(o))
  override def umul(o: Int): Unit = accumulator *= o
  override def udiv(o: Symbol): Unit = udiv(get(o))
  override def udiv(o: Int): Unit = accumulator /= o
  override def umod(o: Symbol): Unit = umod(get(o))
  override def umod(o: Int): Unit = accumulator %= o

  override def uand(o :Symbol) : Unit = uand(get(o))
  override def uand(o :Int) : Unit = set(toBoolean(accumulator) & toBoolean(o))
  override def uor(o :Symbol) : Unit = uor(get(o))
  override def uor(o :Int) : Unit = set(toBoolean(accumulator) | toBoolean(o))

  override def ueq(o :Symbol) : Unit = ueq(get(o))
  override def ueq(o :Int) : Unit = set(accumulator == o)
  override def une(o :Symbol) : Unit = une(get(o))
  override def une(o :Int) : Unit = set(accumulator != o)
  
  override def ult(o :Symbol) : Unit = ult(get(o))
  override def ult(o :Int) : Unit = set(accumulator < o)
  override def ugt(o :Symbol) : Unit = ugt(get(o))
  override def ugt(o :Int) : Unit = set(accumulator > o)

  override def ule(o :Symbol) : Unit = ule(get(o))
  override def ule(o :Int) : Unit = set(accumulator <= o)
  override def uge(o :Symbol) : Unit = uge(get(o))
  override def uge(o :Int) : Unit = set(accumulator >= o)

  override def pneg(): Unit = accumulator = -accumulator
  override def pnot(): Unit = set(!toBoolean(accumulator))
  override def png1() = ???

}
