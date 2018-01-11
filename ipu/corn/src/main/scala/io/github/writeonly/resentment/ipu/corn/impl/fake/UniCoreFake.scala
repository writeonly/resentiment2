package io.github.writeonly.resentment.ipu.corn.impl.fake

import io.github.writeonly.resentment.fsm.api.{Memory, StreamIO}
import io.github.writeonly.resentment.ipu.core.api.UniCore
import io.github.writeonly.resentment.ipu.core.impl.fake.Fake

class UniCoreFake(val io: StreamIO) extends Fake with UniCore[Unit] {

  override def uvar(o: Symbol) = ust(o)

  override def ust(o: Symbol): Unit = symbols(o) = accumulator

  override def uld(o: Symbol): Unit = accumulator = pointer(o)

  override def uld(c: Int): Unit = accumulator = c

  override def uld(o: Char) = accumulator = o

  override def uld(o: String) = accumulator = o.toInt

  override def pin() = accumulator = io.in.read()

  override def pout() = io.out.write(accumulator)

  override def uadd(o: Symbol): Unit = uadd(pointer(o))

  override def uadd(o: Int): Unit = accumulator += o

  override def usub(o: Symbol): Unit = usub(pointer(o))

  override def usub(o: Int): Unit = accumulator -= o

  override def umul(o: Symbol): Unit = umul(pointer(o))

  override def umul(o: Int): Unit = accumulator *= o

  override def udiv(o: Symbol): Unit = udiv(pointer(o))

  override def udiv(o: Int): Unit = accumulator /= o

  override def umod(o: Symbol): Unit = umod(pointer(o))

  override def umod(o: Int): Unit = accumulator %= o

  override def uand(o: Symbol): Unit = uand(pointer(o))

  override def uand(o: Int): Unit = set(Memory.toBoolean(accumulator) & Memory.toBoolean(o))

  override def uor(o: Symbol): Unit = uor(pointer(o))

  override def uor(o: Int): Unit = set(Memory.toBoolean(accumulator) | Memory.toBoolean(o))

  override def ueq(o: Symbol): Unit = ueq(pointer(o))

  override def ueq(o: Int): Unit = set(accumulator == o)

  override def une(o: Symbol): Unit = une(pointer(o))

  override def une(o: Int): Unit = set(accumulator != o)

  override def ult(o: Symbol): Unit = ult(pointer(o))

  override def ult(o: Int): Unit = set(accumulator < o)

  private def set(o: Boolean) = accumulator = Memory.toInt(o)

  override def ugt(o: Symbol): Unit = ugt(pointer(o))

  override def ugt(o: Int): Unit = set(accumulator > o)

  override def ule(o: Symbol): Unit = ule(pointer(o))

  override def ule(o: Int): Unit = set(accumulator <= o)

  override def uge(o: Symbol): Unit = uge(pointer(o))

  override def uge(o: Int): Unit = set(accumulator >= o)

  override def pneg(): Unit = accumulator = -accumulator

  override def pnot(): Unit = set(!Memory.toBoolean(accumulator))

  override def png1() = ???

}
