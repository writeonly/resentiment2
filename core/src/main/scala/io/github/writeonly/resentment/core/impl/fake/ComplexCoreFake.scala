package io.github.writeonly.resentment.core.impl.fake

import io.github.writeonly.resentment.core.api.ComplexCore

class ComplexCoreFake extends Fake with ComplexCore[Unit] {

  override def cconst(s: Int, d: Int) = memory(d) = s.asInstanceOf[Byte]

  override def cclr(d: Int) = memory(d) = 0

  override def cmv(s: Int, d: Int) = memory(d) = memory(s)

  override def cadd(s: Int, d: Int) = comi(s, d, _ + _)

  override def csub(s: Int, d: Int) = comi(s, d, _ - _)

  override def cmul(s: Int, d: Int) = comi(s, d, _ * _)

  override def cdiv(s: Int, d: Int) = comi(s, d, _ / _)

  override def cpow(s: Int, d: Int) = comi(s, d, _ % _)

  override def cswap(d1: Int, d2: Int) = {
    val tmp  = memory(d1)
    memory(d1) = memory(d2)
    memory(d2) = tmp
  }

  override def cneg(d: Int) = memory(d) = toByte(-memory(d))

  override def cnot(d: Int) = memory(d) = toByte(!toBoolean(memory(d)))

  override def ceq(s: Int, d: Int) = comx(s, d, _ == _)

  override def cne(s: Int, d: Int) = comx(s, d, _ != _)

  override def cge(s: Int, d: Int) = comx(s, d, _ <= _)

  override def cgt(s: Int, d: Int) = comx(s, d, _ < _)
}
