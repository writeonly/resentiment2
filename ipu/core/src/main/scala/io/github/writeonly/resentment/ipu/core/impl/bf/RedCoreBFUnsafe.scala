package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFUnsafe(core : OrtoBF) extends RedCore[FString] {

  def this() = this(new OrtoBF)

  def mkm(seq : FString*) = core.mkm(seq:_*)

  override def rnop(): FString = FString.empty

  override def rclr(d: Int): FString = core.rclr(d)

  override def rset(d: Int): FString = core.rset(d)

  override def rswap(d1: Int, d2: Int): FString = core.mkm(raddc(d1, -1), raddc(d2, d1), raddc(-1, d2))

  override def rmov(s: Int, d: Int): FString = core.mov.dir(s, d)

  override def rmovc(s: Int, d: Int): FString = core.mov.cl(s, d)

  override def rmovi(s: Int, d: Int): FString = core.mov.im(s, d)

  override def radd(s: Int, d: Int): FString = core.add.dir(s, d)

  override def raddc(s: Int, d: Int): FString = core.add.cl(s, d)

  override def raddi(s: Int, d: Int): FString = core.add.im(s, d)

  override def rsub(s: Int, d: Int): FString = core.sub.dir(s, d)

  override def rsubc(s: Int, d: Int): FString = core.sub.cl(s, d)

  override def rsubi(s: Int, d: Int): FString = core.sub.im(s, d)

  override def rmulc(s: Int, d: Int): FString = core.mul.cl(s, d)

  override def rmul(s: Int, d: Int): FString = core.mul.dir(s, d)

  override def rmuli(s: Int, d: Int): FString = core.mul.im(s, d)

  override def rdiv(s: Int, d: Int): FString = core.div.dir(s, d)

  override def rdivc(s: Int, d: Int): FString = core.div.cl(s, d)

  override def rdivi(s: Int, d: Int): FString = core.div.im(s, d)

  override def rpow(s: Int, d: Int): FString = core.pow.dir(s, d)

  override def rpowc(s: Int, d: Int): FString = core.pow.cl(s, d)

  override def rpowi(s: Int, d: Int): FString = core.pow.im(s, d)

  override def rmod(s: Int, d: Int): FString = core.mod.dir(s, d)

  override def rmodc(s: Int, d: Int): FString = core.mod.cl(s, d)

  override def rmodi(s: Int, d: Int): FString = core.mod.im(s, d)

  override def rng1(d: Int): FString = core.mkm(core.rdec(d), rneg(d))

  override def rneg(d: Int): FString = core.mkm(rsubc(d, -1), raddc(-1, d))

  override def rnot(d: Int): FString = core.mkm(core.add01(d, -1), core.rinc(d), rsubc(-1, d))

  override def rtau(d: Int): FString = core.mkm(core.add01(d, -1), raddc(-1, d))

  override def req(s: Int, d: Int): FString = core.leq.dir(s, d)

  override def reqc(s: Int, d: Int): FString = core.leq.cl(s, d)

  override def reqi(s: Int, d: Int): FString = core.leq.im(s, d)

  override def rne(s: Int, d: Int): FString = core.lne.dir(s, d)

  override def rnec(s: Int, d: Int): FString = core.lne.cl(s, d)

  override def rnei(s: Int, d: Int): FString = core.lne.im(s, d)

  override def rle(s: Int, d: Int): FString = core.lle.dir(s, d)

  override def rlec(s: Int, d: Int): FString = core.lle.cl(s, d)

  override def rlei(s: Int, d: Int): FString = core.lle.im(s, d)

  override def rlt(s: Int, d: Int): FString = core.llt.dir(s, d)

  override def rltc(s: Int, d: Int): FString = core.llt.cl(s, d)

  override def rlti(s: Int, d: Int): FString = core.llt.im(s, d)
}
