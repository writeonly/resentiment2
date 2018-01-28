package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.RedCore

import io.github.writeonly.resentment.fsm.api.PipeOps.toPipe

abstract class RedCoreWrapper[T, R](core: RedCore[T]) extends RedCore[R] {
  def apply(t: T): R

  override def rnop(): R = core.rnop() |> apply

  override def rclr(d: Int): R = core.rclr(d) |> apply

  override def rset(d: Int): R = core.rset(d) |> apply

  override def rmovi(r: (Int, Int)): R = core.rmovi(r) |> apply

  override def rmov(r: (Int, Int)): R = core.rmov(r) |> apply

  override def rswap(r: (Int, Int)): R = core.rswap(r) |> apply

  override def radd(r: (Int, Int)): R = core.radd(r) |> apply

  override def raddi(r: (Int, Int)): R = core.raddi(r) |> apply

  override def rsub(r: (Int, Int)): R = core.rsub(r) |> apply

  override def rsubi(r: (Int, Int)): R = core.rsubi(r) |> apply

  override def rmul(r: (Int, Int)): R = core.rmul(r) |> apply

  override def rmulc(r: (Int, Int)): R = core.rmulc(r) |> apply

  override def rmuli(r: (Int, Int)): R = core.rmuli(r) |> apply

  override def rdiv(r: (Int, Int)): R = core.rdiv(r) |> apply

  override def rdivc(r: (Int, Int)): R = core.rdivc(r) |> apply

  override def rdivi(r: (Int, Int)): R = core.rdivi(r) |> apply

  override def rmod(r: (Int, Int)): R = core.rmod(r) |> apply

  override def rmodc(r: (Int, Int)): R = core.rmodc(r) |> apply

  override def rmodi(r: (Int, Int)): R = core.rmodi(r) |> apply

  override def rpow(r: (Int, Int)): R = core.rpow(r) |> apply

  override def rpowc(r: (Int, Int)): R = core.rpowc(r) |> apply

  override def rpowi(r: (Int, Int)): R = core.rpowi(r) |> apply

  override def rneg(d: Int): R = core.rneg(d) |> apply

  override def rng1(d: Int): R = core.rng1(d) |> apply

  override def rnot(d: Int): R = core.rnot(d) |> apply

  override def rtau(d: Int): R = core.rtau(d) |> apply

  override def req(r: (Int, Int)): R = core.req(r) |> apply

  override def reqc(r: (Int, Int)): R = core.reqc(r) |> apply

  override def reqi(r: (Int, Int)): R = core.reqi(r) |> apply

  override def rne(r: (Int, Int)): R = core.rne(r) |> apply

  override def rnec(r: (Int, Int)): R = core.rnec(r) |> apply

  override def rnei(r: (Int, Int)): R = core.rnei(r) |> apply

  override def rle(r: (Int, Int)): R = core.rle(r) |> apply

  override def rlec(r: (Int, Int)): R = core.rlec(r) |> apply

  override def rlei(r: (Int, Int)): R = core.rlei(r) |> apply

  override def rlt(r: (Int, Int)): R = core.rlt(r) |> apply

  override def rltc(r: (Int, Int)): R = core.rltc(r) |> apply

  override def rlti(r: (Int, Int)): R = core.rlti(r) |> apply

  override def rmovc(r: (Int, Int)): R = core.rmovc(r) |> apply

  override def raddc(r: (Int, Int)): R = core.raddc(r) |> apply

  override def rsubc(r: (Int, Int)): R = core.rsubc(r) |> apply

  override def rand(r: (Int, Int)): R = core.rand(r) |> apply

  override def randc(r: (Int, Int)): R = core.randc(r) |> apply

  override def randi(r: (Int, Int)): R = core.randi(r) |> apply

  override def ror(r: (Int, Int)): R = core.ror(r) |> apply

  override def rorc(r: (Int, Int)): R = core.rorc(r) |> apply

  override def rori(r: (Int, Int)): R = core.rori(r) |> apply

}
