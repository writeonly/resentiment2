package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.RedCore

abstract class RedCoreWrapper[T, R](core: RedCore[T]) extends RedCore[R] {
  def apply(t: T): R

  override def rnop(): R = apply(core.rnop())

  override def rclr(d: Int): R = apply(core.rclr(d))

  override def rset(d: Int): R = apply(core.rset(d))

  override def rmovi(s: Int, d: Int): R = apply(core.rmovi(s, d))

  override def rmov(s: Int, d: Int): R = apply(core.rmov(s, d))

  override def rswap(d1: Int, d2: Int): R = apply(core.rswap(d1, d2))

  override def radd(s: Int, d: Int): R = apply(core.radd(s, d))

  override def raddi(s: Int, d: Int): R = apply(core.raddi(s, d))

  override def rsub(s: Int, d: Int): R = apply(core.rsub(s, d))

  override def rsubi(s: Int, d: Int): R = apply(core.rsubi(s, d))

  override def rmul(s: Int, d: Int): R = apply(core.rmul(s, d))

  override def rmulc(s: Int, d: Int): R = apply(core.rmulc(s, d))

  override def rmuli(s: Int, d: Int): R = apply(core.rmuli(s, d))

  override def rdiv(s: Int, d: Int): R = apply(core.rdiv(s, d))

  override def rdivc(s: Int, d: Int): R = apply(core.rdivc(s, d))

  override def rdivi(s: Int, d: Int): R = apply(core.rdivi(s, d))

  override def rmod(s: Int, d: Int): R = apply(core.rdiv(s, d))

  override def rmodc(s: Int, d: Int): R = apply(core.rmodc(s, d))

  override def rmodi(s: Int, d: Int): R = apply(core.rmodi(s, d))

  override def rpow(s: Int, d: Int): R = apply(core.rpow(s, d))

  override def rpowi(s: Int, d: Int): R = apply(core.rpowi(s, d))

  override def rneg(d: Int): R = apply(core.rneg(d))

  override def rng1(d: Int): R = apply(core.rng1(d))

  override def rnot(d: Int): R = apply(core.rnot(d))

  override def rtau(d: Int): R = apply(core.rtau(d))

  override def req(s: Int, d: Int): R = apply(core.req(s, d))

  override def reqc(s: Int, d: Int): R = apply(core.reqc(s, d))

  override def reqi(s: Int, d: Int): R = apply(core.reqi(s, d))

  override def rne(s: Int, d: Int): R = apply(core.rne(s, d))

  override def rnec(s: Int, d: Int): R = apply(core.rnec(s, d))

  override def rnei(s: Int, d: Int): R = apply(core.rnei(s, d))

  override def rle(s: Int, d: Int): R = apply(core.rle(s, d))

  override def rlec(s: Int, d: Int): R = apply(core.rlec(s, d))

  override def rlei(s: Int, d: Int): R = apply(core.rlei(s, d))

  override def rlt(s: Int, d: Int): R = apply(core.rlt(s, d))

  override def rltc(s: Int, d: Int): R = apply(core.rltc(s, d))

  override def rlti(s: Int, d: Int): R = apply(core.rlti(s, d))

  override def rmovc(s: Int, d: Int): R = apply(core.rmovc(s, d))

  override def raddc(s: Int, d: Int): R = apply(core.raddc(s, d))

  override def rsubc(s: Int, d: Int): R = apply(core.rsubc(s, d))

}
