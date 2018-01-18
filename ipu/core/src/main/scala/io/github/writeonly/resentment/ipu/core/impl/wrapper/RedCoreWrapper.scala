package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.RedCore

abstract class RedCoreWrapper[T, R](core: RedCore[T]) extends RedCore[R] {
  def apply(t: T): R

  override def rnop(): R = apply(core.rnop())

  override def rclr(d: Int): R = apply(core.rclr(d))

  override def rset(d: Int): R = apply(core.rset(d))

  override def rmovi(r: (Int, Int)): R = apply(core.rmovi(r))

  override def rmov(r: (Int, Int)): R = apply(core.rmov(r))

  override def rswap(r: (Int, Int)): R = apply(core.rswap(r))

  override def radd(r: (Int, Int)): R = apply(core.radd(r))

  override def raddi(r: (Int, Int)): R = apply(core.raddi(r))

  override def rsub(r: (Int, Int)): R = apply(core.rsub(r))

  override def rsubi(r: (Int, Int)): R = apply(core.rsubi(r))

  override def rmul(r: (Int, Int)): R = apply(core.rmul(r))

  override def rmulc(r: (Int, Int)): R = apply(core.rmulc(r))

  override def rmuli(r: (Int, Int)): R = apply(core.rmuli(r))

  override def rdiv(r: (Int, Int)): R = apply(core.rdiv(r))

  override def rdivc(r: (Int, Int)): R = apply(core.rdivc(r))

  override def rdivi(r: (Int, Int)): R = apply(core.rdivi(r))

  override def rmod(r: (Int, Int)): R = apply(core.rmod(r))

  override def rmodc(r: (Int, Int)): R = apply(core.rmodc(r))

  override def rmodi(r: (Int, Int)): R = apply(core.rmodi(r))

  override def rpow(r: (Int, Int)): R = apply(core.rpow(r))

  override def rpowc(r: (Int, Int)): R = apply(core.rpowc(r))

  override def rpowi(r: (Int, Int)): R = apply(core.rpowi(r))

  override def rneg(d: Int): R = apply(core.rneg(d))

  override def rng1(d: Int): R = apply(core.rng1(d))

  override def rnot(d: Int): R = apply(core.rnot(d))

  override def rtau(d: Int): R = apply(core.rtau(d))

  override def req(r: (Int, Int)): R = apply(core.req(r))

  override def reqc(r: (Int, Int)): R = apply(core.reqc(r))

  override def reqi(r: (Int, Int)): R = apply(core.reqi(r))

  override def rne(r: (Int, Int)): R = apply(core.rne(r))

  override def rnec(r: (Int, Int)): R = apply(core.rnec(r))

  override def rnei(r: (Int, Int)): R = apply(core.rnei(r))

  override def rle(r: (Int, Int)): R = apply(core.rle(r))

  override def rlec(r: (Int, Int)): R = apply(core.rlec(r))

  override def rlei(r: (Int, Int)): R = apply(core.rlei(r))

  override def rlt(r: (Int, Int)): R = apply(core.rlt(r))

  override def rltc(r: (Int, Int)): R = apply(core.rltc(r))

  override def rlti(r: (Int, Int)): R = apply(core.rlti(r))

  override def rmovc(r: (Int, Int)): R = apply(core.rmovc(r))

  override def raddc(r: (Int, Int)): R = apply(core.raddc(r))

  override def rsubc(r: (Int, Int)): R = apply(core.rsubc(r))

  override def rand(r: (Int, Int)): R = apply(core.rand(r))

  override def randc(r: (Int, Int)): R = apply(core.randc(r))

  override def randi(r: (Int, Int)): R = apply(core.randi(r))

  override def ror(r: (Int, Int)): R = apply(core.ror(r))

  override def rorc(r: (Int, Int)): R = apply(core.rorc(r))

  override def rori(r: (Int, Int)): R = apply(core.rori(r))

}
