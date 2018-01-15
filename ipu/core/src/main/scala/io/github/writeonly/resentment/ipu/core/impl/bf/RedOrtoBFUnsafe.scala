package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedOrtoBFUnsafe extends OrtoBF with RedCore[FString] {

  override def rnop(): FString = FString.empty

  override def rswap(d1: Int, d2: Int): FString = mkm(raddc(d1, -1), raddc(d2, d1), raddc(-1, d2))

  override def rmov(s: Int, d: Int): FString = mov.dir(s, d)

  override def rmovc(s: Int, d: Int): FString = mov.cl(s, d)

  override def rmovi(s: Int, d: Int): FString = mov.im(s, d)

  override def radd(s: Int, d: Int): FString = add.dir(s, d)

  override def raddc(s: Int, d: Int): FString = add.cl(s, d)

  override def raddi(s: Int, d: Int): FString = add.im(s, d)

  override def rsub(s: Int, d: Int): FString = sub.dir(s, d)

  override def rsubc(s: Int, d: Int): FString = sub.cl(s, d)

  override def rsubi(s: Int, d: Int): FString = sub.im(s, d)

  override def rmulc(s: Int, d: Int): FString = mul.cl(s, d)

  override def rmul(s: Int, d: Int): FString = mul.dir(s, d)

  override def rmuli(s: Int, d: Int): FString = mul.im(s, d)

  override def rdiv(s: Int, d: Int): FString = div.dir(s, d)

  override def rdivc(s: Int, d: Int): FString = div.cl(s, d)

  override def rdivi(s: Int, d: Int): FString = div.im(s, d)

  override def rpow(s: Int, d: Int): FString = pow.dir(s, d)

  override def rpowc(s: Int, d: Int): FString = pow.cl(s, d)

  override def rpowi(s: Int, d: Int): FString = pow.im(s, d)

  override def rmod(s: Int, d: Int): FString = mod.dir(s, d)

  override def rmodc(s: Int, d: Int): FString = mod.cl(s, d)

  override def rmodi(s: Int, d: Int): FString = mod.im(s, d)

  override def rng1(d: Int): FString = mkm(rdec(d), rneg(d))

  override def rneg(d: Int): FString = mkm(rsubc(d, -1), raddc(-1, d))

  override def rnot(d: Int): FString = mkm(add01(d, -1), rinc(d), rsubc(-1, d))

  override def rtau(d: Int): FString = mkm(add01(d, -1), raddc(-1, d))

  override def req(s: Int, d: Int): FString = mkm(raddc(d, -2), rinc(d), subt(s, -2, -1), sub01(-2, d))

  override def reqc(s: Int, d: Int): FString = mkm(raddc(d, -2), rinc(d), rsubc(s, -2), sub01(-2, d))

  override def reqi(s: Int, d: Int): FString = mkm(raddc(d, -1), rsubi(s, -1), sub01(-1, d))

  override def rne(s: Int, d: Int): FString = mkm(raddc(d, -2), subt(s, -2, -1), add01(-2, d))

  override def rnec(s: Int, d: Int): FString = mkm(raddc(d, -2), rsubc(s, -2), add01(-2, d))

  override def rnei(s: Int, d: Int): FString = mkm(raddc(d, -1), rsubi(s, -1), add01(-1, d))

  override def rle(s: Int, d: Int): FString = mkm(rinc(-3), addt(s, -2, -1), raddc(d, -1), rinc(d), ge1(d), ge3(d))

  override def rlec(s: Int, d: Int): FString = mkm(rinc(-3), raddc(s, -2), raddc(d, -1), rinc(d), ge1(d), ge3(d))

  override def rlei(s: Int, d: Int): FString = mkm(rinc(-3), addt(s, -2, -1), raddc(d, -1), rinc(d), ge1(d), ge3(d))

  override def rlt(s: Int, d: Int): FString = mkm(rinc(-3), addt(s, -1, -2), raddc(d, -2), gt1(d), gt3(d))

  override def rltc(s: Int, d: Int): FString = mkm(rinc(-3), raddc(s, -1), raddc(d, -2), gt1(d), gt3(d))

  override def rlti(s: Int, d: Int): FString = mkm(rinc(-3), addt(s, -1, -2), raddc(d, -2), gt1(d), gt3(d))

}
