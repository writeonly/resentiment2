package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.fsm.api.Memory
import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreFake extends Fake with ComplexCore[Unit] {

  override def cnop(): Unit = {}

  override def cclr(d: Int): Unit = memory(d) = 0

  override def cset(d: Int): Unit = memory(d) = 1

  override def cmovi(s: Int, d: Int): Unit = memory(d) = s.asInstanceOf[Byte]

  override def cmov(s: Int, d: Int): Unit = memory(d) = memory(s)

  override def cswap(d1: Int, d2: Int): Unit = {
    val tmp = memory(d1)
    memory(d1) = memory(d2)
    memory(d2) = tmp
  }

  override def cadd(s: Int, d: Int): Unit = comi(s, d, _ + _)

  override def csub(s: Int, d: Int): Unit = comi(s, d, _ - _)

  override def cmul(s: Int, d: Int): Unit = comi(s, d, _ * _)

  override def cdiv(s: Int, d: Int): Unit = comi(s, d, _ / _)

  override def cpow(s: Int, d: Int): Unit = comi(s, d, _ % _)

  override def cneg(d: Int): Unit = memory(d) = -memory(d)

  override def cng1(d: Int): Unit = memory(d) = -memory(d) + 1

  override def cnot(d: Int): Unit = memory(d) = !Memory.toBoolean(memory(d))

  override def ceq(s: Int, d: Int): Unit = comx(s, d, _ == _)

  override def cne(s: Int, d: Int): Unit = comx(s, d, _ != _)

  override def cle(s: Int, d: Int): Unit = comx(s, d, _ >= _)

  override def clt(s: Int, d: Int): Unit = comx(s, d, _ > _)

}
