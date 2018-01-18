package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFSafe(core: RedCoreBFUnsafe) extends RedCore[FString] {

  def this() = this(new RedCoreBFUnsafe())

  override def rswap(d1: Int, d2: Int): FString =
    if (d1 != d2) core.rswap(d1, d2) else rnop()

  override def rmovc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rmovc(r) else rclr(r._2)

  override def radd(r: (Int, Int)): FString =
    if (r._1 != r._2) core.radd(r)
    else core.mkm(rmovi(2, -3), core.rmul(-3, r._2))

  override def rmovi(r: (Int, Int)): FString = core.rmovi(r)

  override def raddc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.raddc(r) else rclr(r._2)

  override def raddi(r: (Int, Int)): FString = core.raddi(r)

  override def rsub(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rsub(r) else rclr(r._2)

  override def rsubc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rsubc(r) else rclr(r._2)

  override def rsubi(r: (Int, Int)): FString = core.rsubi(r)

  override def rmul(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rmul(r)
    else core.mkm(rmov(r._1, -3), core.rmul(-3, r._2))

  override def rmov(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rmov(r) else rnop()

  override def rnop(): FString = core.rnop()

  override def rmulc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rmulc(r) else rclr(r._2)

  override def rmuli(r: (Int, Int)): FString = core.rmuli(r)

  override def rdiv(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rdiv(r) else rset(r._2)

  override def rset(d: Int): FString = core.rset(d)

  override def rdivc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rdivc(r) else rclr(r._2)

  override def rdivi(r: (Int, Int)): FString = core.rdivi(r)

  override def rmod(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rmod(r) else rclr(r._2)

  override def rmodc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rmodc(r) else rclr(r._2)

  override def rmodi(r: (Int, Int)): FString = core.rmodi(r)

  override def rpow(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rpow(r)
    else core.mkm(radd(r._1, -5), core.rpowc(-5, r._2))

  override def rpowc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rpowc(r) else rclr(r._2)

  override def rpowi(r: (Int, Int)): FString = core.rpowi(r)

  override def rneg(d: Int): FString = core.rneg(d)

  override def rng1(d: Int): FString = core.rng1(d)

  override def rnot(d: Int): FString = core.rnot(d)

  override def rtau(d: Int): FString = core.rtau(d)

  override def req(r: (Int, Int)): FString =
    if (r._1 != r._2) core.req(r) else rset(r._2)

  override def reqc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.reqc(r) else rclr(r._2)

  override def rne(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rne(r) else rclr(r._2)

  override def rnec(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rnec(r) else rclr(r._2)

  override def rclr(d: Int): FString = core.rclr(d)

  override def reqi(r: (Int, Int)): FString = core.reqi(r)

  override def rnei(r: (Int, Int)): FString = core.rnei(r)

  override def rle(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rle(r) else rset(r._2)

  override def rlec(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rlec(r) else rclr(r._2)

  override def rlei(r: (Int, Int)): FString = core.rlei(r)

  override def rlt(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rlt(r) else rclr(r._2)

  override def rltc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rltc(r) else rclr(r._2)

  override def rlti(r: (Int, Int)): FString = core.rlti(r)

  override def rand(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rand(r) else rset(r._2)

  override def randc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.randc(r) else rclr(r._2)

  override def randi(r: (Int, Int)): FString = core.randi(r)

  override def ror(r: (Int, Int)): FString =
    if (r._1 != r._2) core.ror(r) else rset(r._2)

  override def rorc(r: (Int, Int)): FString =
    if (r._1 != r._2) core.rorc(r) else rclr(r._2)

  override def rori(r: (Int, Int)): FString = core.rori(r)

}
