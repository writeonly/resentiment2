package io.github.writeonly.resentment.core.impl.fake

import io.github.writeonly.resentment.core.api.ComplexCore

class ComplexCoreFake extends Fake with ComplexCore[Unit] {

  override def cconst(s: Int, d: Int) = stack(d) = s.asInstanceOf

  override def cclr(d: Int) = stack(d) = 0

  override def cmv(s: Int, d: Int) = stack(d) = stack(s)

  override def cadd(s: Int, d: Int) = stack(d) = toByte(stack(d) + stack(s))

  override def csub(s: Int, d: Int) = stack(d) = toByte(stack(d) - stack(s))

  override def cmul(s: Int, d: Int) = stack(d) = toByte(stack(d) * stack(s))

  override def cdiv(s: Int, d: Int) = stack(d) = toByte(stack(d) / stack(s))

  override def cpow(s: Int, d: Int) = stack(d) = toByte(stack(d) % stack(s))

  override def cswap(d1: Int, d2: Int) = {
    val tmp  = stack(d1)
    stack(d1) = stack(d2)
    stack(d2) = tmp
  }

  override def cneg(d: Int) = stack(d) = (-stack(d)).asInstanceOf

  override def cnot(d: Int) = ???

  override def ceq(s: Int, d: Int) = ???

  override def cne(s: Int, d: Int) = ???

  override def cge(s: Int, d: Int) = ???

  override def cgt(s: Int, d: Int) = ???
}
