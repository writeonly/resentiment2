package io.github.writeonly.resentment.ipu.core.impl.common

import io.github.writeonly.resentment.ipu.core.api.ComplexCore

abstract class ComplexCoreWrapper[T, R](core: ComplexCore[T]) extends ComplexCore[R] {
  def apply(t: T): R

  override def cnop(): R = apply(core.cnop())

  override def cclr(d: Int): R = apply(core.cclr(d))

  override def cset(d: Int): R = apply(core.cset(d))

  override def cconst(s: Int, d: Int): R = apply(core.cconst(s, d))

  override def cmov(s: Int, d: Int): R = apply(core.cmov(s, d))

  override def cswap(d1: Int, d2: Int): R = apply(core.cswap(d1, d2))

  override def cadd(s: Int, d: Int): R = apply(core.cadd(s, d))

  override def csub(s: Int, d: Int): R = apply(core.csub(s, d))

  override def cmul(s: Int, d: Int): R = apply(core.cmul(s, d))

  override def cdiv(s: Int, d: Int): R = apply(core.cdiv(s, d))

  override def cpow(s: Int, d: Int): R = apply(core.cpow(s, d))

  override def cneg(d: Int): R = apply(core.cneg(d))

  override def cng1(d: Int): R = apply(core.cng1(d))

  override def cnot(d: Int): R = apply(core.cnot(d))

  override def ceq(s: Int, d: Int): R = apply(core.ceq(s, d))

  override def cne(s: Int, d: Int): R = apply(core.cne(s, d))

  override def cle(s: Int, d: Int): R = apply(core.cle(s, d))

  override def clt(s: Int, d: Int): R = apply(core.clt(s, d))
}
