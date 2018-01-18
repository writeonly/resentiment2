package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFUnsafe(core: OrtoBF) extends RedCore[FString] {

  def this() = this(new OrtoBF)

  def mkm(seq: FString*) = core.mkm(seq: _*)

  override def rnop(): FString = FString.empty

  override def rclr(d: Int): FString = core.rclr(d)

  override def rset(d: Int): FString = core.rset(d)

  override def rswap(d1: Int, d2: Int): FString =
    core.mkm(raddc(d1, -1), raddc(d2, d1), raddc(-1, d2))

  override def rmov(r: (Int, Int)): FString = core.mov.dir(r)

  override def rmovc(r: (Int, Int)): FString = core.mov.cl(r)

  override def rmovi(r: (Int, Int)): FString = core.mov.im(r)

  override def radd(r: (Int, Int)): FString = core.add.dir(r)

  override def raddc(r: (Int, Int)): FString = core.add.cl(r)

  override def raddi(r: (Int, Int)): FString = core.add.im(r)

  override def rsub(r: (Int, Int)): FString = core.sub.dir(r)

  override def rsubc(r: (Int, Int)): FString = core.sub.cl(r)

  override def rsubi(r: (Int, Int)): FString = core.sub.im(r)

  override def rmulc(r: (Int, Int)): FString = core.mul.cl(r)

  override def rmul(r: (Int, Int)): FString = core.mul.dir(r)

  override def rmuli(r: (Int, Int)): FString = core.mul.im(r)

  override def rdiv(r: (Int, Int)): FString = core.div.dir(r)

  override def rdivc(r: (Int, Int)): FString = core.div.cl(r)

  override def rdivi(r: (Int, Int)): FString = core.div.im(r)

  override def rpow(r: (Int, Int)): FString = core.pow.dir(r)

  override def rpowc(r: (Int, Int)): FString = core.pow.cl(r)

  override def rpowi(r: (Int, Int)): FString = core.pow.im(r)

  override def rmod(r: (Int, Int)): FString = core.mod.dir(r)

  override def rmodc(r: (Int, Int)): FString = core.mod.cl(r)

  override def rmodi(r: (Int, Int)): FString = core.mod.im(r)

  override def rng1(d: Int): FString = core.mkm(core.rdec(d), rneg(d))

  override def rneg(d: Int): FString = core.mkm(rsubc(d, -1), raddc(-1, d))

  override def rnot(d: Int): FString =
    core.mkm(core.add01(d, -1), core.rinc(d), rsubc(-1, d))

  override def rtau(d: Int): FString = core.mkm(core.add01(d, -1), raddc(-1, d))

  override def req(r: (Int, Int)): FString = core.leq.dir(r)

  override def reqc(r: (Int, Int)): FString = core.leq.cl(r)

  override def reqi(r: (Int, Int)): FString = core.leq.im(r)

  override def rne(r: (Int, Int)): FString = core.lne.dir(r)

  override def rnec(r: (Int, Int)): FString = core.lne.cl(r)

  override def rnei(r: (Int, Int)): FString = core.lne.im(r)

  override def rle(r: (Int, Int)): FString = core.lle.dir(r)

  override def rlec(r: (Int, Int)): FString = core.lle.cl(r)

  override def rlei(r: (Int, Int)): FString = core.lle.im(r)

  override def rlt(r: (Int, Int)): FString = core.llt.dir(r)

  override def rltc(r: (Int, Int)): FString = core.llt.cl(r)

  override def rlti(r: (Int, Int)): FString = core.llt.im(r)

  override def rand(r: (Int, Int)): FString = core.land.dir(r)

  override def randc(r: (Int, Int)): FString = core.land.cl(r)

  override def randi(r: (Int, Int)): FString = core.land.im(r)

  override def ror(r: (Int, Int)): FString = core.lor.dir(r)

  override def rorc(r: (Int, Int)): FString = core.lor.cl(r)

  override def rori(r: (Int, Int)): FString = core.lor.im(r)

}
