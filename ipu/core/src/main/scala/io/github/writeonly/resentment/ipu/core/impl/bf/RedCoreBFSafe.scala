package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFSafe(core: RedCoreBFUnsafe) extends RedCore[FString] {

  def this() = this(new RedCoreBFUnsafe)

  override def rnop(): FString = core.rnop()

  override def rclr(d: Int): FString = core.rclr(d)

  override def rset(d: Int): FString = core.rset(d)

  override def rmovi(s: Int, d: Int): FString = core.rmovi(s, d)

  override def rmov(s: Int, d: Int): FString = if (s != d) core.rmov(s, d) else rnop()

  override def rswap(d1: Int, d2: Int): FString = if (d1 != d2) core.rswap(d1, d2) else rnop()

  override def radd(s: Int, d: Int): FString = if (s != d) core.radd(s, d) else core.mk(rmovi(2, -3), core.rmul(-3, d))

  override def raddi(s: Int, d: Int): FString = core.raddi(s, d)

  override def rsub(s: Int, d: Int): FString = if (s != d) core.rsub(s, d) else rclr(d)

  override def rsubi(s: Int, d: Int): FString = core.rsubi(s, d)

  override def rmul(s: Int, d: Int): FString = if (s != d) core.rmul(s, d) else core.mk(rmov(s, -3), core.rmul(-3, d))

  override def rmuli(s: Int, d: Int): FString = core.rmuli(s, d)

  override def rdiv(s: Int, d: Int): FString = if (s != d) core.rdiv(s, d) else rset(d)

  override def rdivi(s: Int, d: Int): FString = core.rdivi(s, d)

  override def rpow(s: Int, d: Int): FString = if (s != d) core.rpow(s, d) else core.mk(rmov(s, -5), core.rpowc(s, d), core.add1(-5, s))

  override def rneg(d: Int): FString = core.rneg(d)

  override def rng1(d: Int): FString = core.rng1(d)

  override def rnot(d: Int): FString = core.rnot(d)

  override def req(s: Int, d: Int): FString = if (s != d) core.req(s, d) else rset(d)

  override def rne(s: Int, d: Int): FString = if (s != d) core.rne(s, d) else rclr(d)

  override def rle(s: Int, d: Int): FString = if (s != d) core.rle(s, d) else rset(d)

  override def rlt(s: Int, d: Int): FString = if (s != d) core.rlt(s, d) else rclr(d)

}
