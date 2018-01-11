package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFSafe(core: RedCoreBFUnsafe) extends RedCore[FString] {

  def this() = this(new RedCoreBFUnsafe)

  override def rswap(d1: Int, d2: Int): FString = if (d1 != d2) core.rswap(d1, d2) else rnop()

  override def rnop(): FString = core.rnop()

  override def rmovc(s: Int, d: Int): FString = if (s != d) core.rmovc(s, d) else rclr(d)

  override def radd(s: Int, d: Int): FString = if (s != d) core.radd(s, d) else core.mkm(rmovi(2, -3), core.rmul(-3, d))

  override def rmovi(s: Int, d: Int): FString = core.rmovi(s, d)

  override def raddc(s: Int, d: Int): FString = if (s != d) core.raddc(s, d) else rclr(d)

  override def raddi(s: Int, d: Int): FString = core.raddi(s, d)

  override def rsub(s: Int, d: Int): FString = if (s != d) core.rsub(s, d) else rclr(d)

  override def rsubc(s: Int, d: Int): FString = if (s != d) core.rsubc(s, d) else rclr(d)

  override def rsubi(s: Int, d: Int): FString = core.rsubi(s, d)

  override def rmul(s: Int, d: Int): FString = if (s != d) core.rmul(s, d) else core.mkm(rmov(s, -3), core.rmul(-3, d))

  override def rmov(s: Int, d: Int): FString = if (s != d) core.rmov(s, d) else rnop()

  override def rmuli(s: Int, d: Int): FString = core.rmuli(s, d)

  override def rdiv(s: Int, d: Int): FString = if (s != d) core.rdiv(s, d) else rset(d)

  override def rdivi(s: Int, d: Int): FString = core.rdivi(s, d)

  override def rpow(s: Int, d: Int): FString = if (s != d) core.rpow(s, d) else core.mkm(rmov(s, -5), core.rpowc(s, d), core.raddc(-5, s))

  override def rpowi(s: Int, d: Int): FString = core.rpowi(s, d)

  override def rneg(d: Int): FString = core.rneg(d)

  override def rng1(d: Int): FString = core.rng1(d)

  override def rnot(d: Int): FString = core.rnot(d)

  override def rtau(d: Int): FString = core.rtau(d)

  override def req(s: Int, d: Int): FString = if (s != d) core.req(s, d) else rset(d)

  override def reqc(s: Int, d: Int): FString = if (s != d) core.reqc(s, d) else rclr(d)

  override def rne(s: Int, d: Int): FString = if (s != d) core.rne(s, d) else rclr(d)

  override def rnec(s: Int, d: Int): FString = if (s != d) core.rnec(s, d) else rclr(d)

  override def rclr(d: Int): FString = core.rclr(d)

  override def reqi(s: Int, d: Int): FString = core.reqi(s, d)

  override def rnei(s: Int, d: Int): FString = core.rnei(s, d)

  override def rle(s: Int, d: Int): FString = if (s != d) core.rle(s, d) else rset(d)

  override def rlec(s: Int, d: Int): FString = if (s != d) core.rlec(s, d) else rclr(d)

  override def rset(d: Int): FString = core.rset(d)

  override def rlei(s: Int, d: Int): FString = core.rlei(s, d)

  override def rlt(s: Int, d: Int): FString = if (s != d) core.rlt(s, d) else rclr(d)

  override def rltc(s: Int, d: Int): FString = if (s != d) core.rltc(s, d) else rclr(d)

  override def rlti(s: Int, d: Int): FString = core.rlti(s, d)

}
