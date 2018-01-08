package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFUnsafe extends CoreBF with RedCore[FString] {

  override def rnop(): FString = FString.empty

  override def rmov(s: Int, d: Int): FString = mk(rclr(d), radd(s, d))

  override def rswap(d1: Int, d2: Int): FString = mk(add1(d1, -1), add1(d2, d1), add1(-1, d2))

  override def radd(s: Int, d: Int): FString = mk(addt(s, d, -1))

  override def raddi(s: Int, d: Int): FString = r(d, raddi(s))

  override def rsub(s: Int, d: Int): FString = mk(subt(s, d, -1))

  override def rsubi(s: Int, d: Int): FString = r(d, rsubi(s))

  override def rmul(s: Int, d: Int): FString = mk(add1(d, -2), rw(-2, "-", radd(s, d)))

  override def rmuli(s: Int, d: Int): FString = mk(add1(d, -1), rw(-1, "-", raddi(s, d)))

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

  override def rdiv(s: Int, d: Int): FString = mk(
    add1(d, -1),
    rw(-1,
      addt(s, -2, -3),
      rw(-2, "-",
        r(-3, "+"),
        r(-1, "-"),
        rw(-1, "-", r(-3, "[-]"), r(-4, "+")),
        rw(-4, "-", r(-1, "+")),
        rw(-3, "-", r(-2, "-"), rw(-2, "[-]", "+", r(d, "-")))
      ),
      r(d, "+")
    )
  )

  override def rdivi(s: Int, d: Int) = mk(
    add1(d, -1),
    rw(-1,
      raddi(s, -2),
      rw(-2, "-",
        r(-3, "+"),
        r(-1, "-"),
        rw(-1, "-", r(-3, "[-]"), r(-4, "+")),
        rw(-4, "-", r(-1, "+")),
        rw(-3, "-", r(-2, "-"), rw(-2, "[-]", "+", r(d, "-")))
      ),
      r(d, "+")
    )
  )

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

  def rpowc(s: Int, d: Int): FString = mk(
    add1(d, -1),
    raddi(1, d),
    rw(s, "-",
      rclr(-2),
      rclr(-3),
      add1(d, -3),
      rw(-3, "-", addt(-1, d, -2))
    )
  )

  override def rpow(s: Int, d: Int): FString = mk(rmov(s, -4), rpowc(s, d), add1(-4, s))

  override def rpowi(s: Int, d: Int): FString = mk(add1(s, -4), rpowc(s, d))

  override def rneg(d: Int): FString = mk(sub1(d, -1), add1(-1, d))

  override def rng1(d: Int): FString = mk(raddi(-1, d), rneg(d))

  override def rnot(d: Int): FString = mk(raddi(-1, d), rneg(d))

  override def req(s: Int, d: Int): FString = mk(add1(d, -2, "+"), subt(s, -2, -1), sub01(-2, d))

  override def rne(s: Int, d: Int): FString = mk(add1(d, -2), subt(s, -2, -1), add01(-2, d))

  override def rle(s: Int, d: Int): FString = mk(r(-3, "+"), addt(s, -2, -1), add1(d, -1, "+"), ge1(d), ge3(d))

  override def rlt(s: Int, d: Int): FString = mk(r(-3, "+"), addt(s, -1, -2), add1(d, -2), gt1(d), gt3(d))

}
