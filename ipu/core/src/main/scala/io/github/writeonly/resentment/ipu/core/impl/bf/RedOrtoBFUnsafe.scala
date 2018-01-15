package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedOrtoBFUnsafe extends OrtoBF with RedCore[FString] {

  override def rnop(): FString = FString.empty

  override def rswap(d1: Int, d2: Int): FString = mkm(raddc(d1, -1), raddc(d2, d1), raddc(-1, d2))

  override def rmovc(s: Int, d: Int): FString = mkm(rclr(d), raddc(s, d))

  override def rsub(s: Int, d: Int): FString = mkm(subt(s, d, -1))

  override def rmulc(s: Int, d: Int): FString = mkm(rmul(s, d), rclr(s))

  override def rmul(s: Int, d: Int): FString = mkm(raddc(d, -2), hs(-2, "-", radd(s, d)))

  override def radd(s: Int, d: Int): FString = mkm(addt(s, d, -1))

  override def rmuli(s: Int, d: Int): FString = mkm(raddc(d, -1), hs(-1, "-", raddi(s, d)))

  override def rdivc(s: Int, d: Int): FString = mkm(rdiv(s, d), rclr(s))

  //  temp0[-]
  //  temp1[-]
  //  temp2[-]
  //  temp3[-]
  //  x[temp0+x-]
  //  temp0[
  //    y[temp1+temp2+y-]
  //    temp2[y+temp2-]
  //    temp1[
  //      temp2+
  //      temp0-
  //      [temp2[-]temp3+temp0-]
  //      temp3[temp0+temp3-]
  //      temp2[
  //        temp1-
  //        [x-temp1[-]]+
  //      temp2-]
  //    temp1-]
  //    x+
  //  temp0]
  override def rdiv(s: Int, d: Int): FString = mkm(
    raddc(d, -1),
    hs(-1,
      addt(s, -2, -3),
      hs(-2, "-",
        rinc(-3),
        rdec(-1),
        hs(-1, "-", rclr(-3), rinc(-4)),
        hs(-4, "-", rinc(-1)),
        hs(-3, "-", rdec(-2), hm(-2, "[-]", rdec(d)), rinc(-2))
      ),
      h(d, "+")
    )
  )

  override def rdivi(s: Int, d: Int) = mkm(
    raddc(d, -1),
    hs(-1,
      raddi(s, -2),
      hs(-2, "-",
        rinc(-3),
        rdec(-1),
        hs(-1, "-", rclr(-3), rinc(-4)),
        hs(-4, "-", rinc(-1)),
        hs(-3, "-", rdec(-2), hm(-2, "[-]", rdec(d)), rinc(-2))
      ),
      h(d, "+")
    )
  )

  override def rpow(s: Int, d: Int): FString = mkm(rmov(s, -4), rpowc(s, d), raddc(-4, s))

  override def rmov(s: Int, d: Int): FString = mkm(rclr(d), radd(s, d))

  //  temp0[-]
  //  x[temp0+x-]
  //  x+
  //  y[
  //    temp1[-]
  //    temp2[-]
  //    x[temp2+x-]
  //    temp2[
  //      temp0[x+temp1+temp0-]
  //      temp1[temp0+temp1-]
  //    temp2-]
  //  y-]

  def rpowc(s: Int, d: Int): FString = mkm(
    raddc(d, -1),
    rinc(d),
    hs(s, "-",
      rclr(-2),
      rclr(-3),
      raddc(d, -3),
      hs(-3, "-", addt(-1, d, -2))
    )
  )

  override def rpowi(s: Int, d: Int): FString = mkm(raddi(s, -4), rpowc(-4, d))

  override def rmod(s: Int, d: Int): FString = ???

  override def rmodc(s: Int, d: Int): FString = ???

  override def rmodi(s: Int, d: Int): FString = ???

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
