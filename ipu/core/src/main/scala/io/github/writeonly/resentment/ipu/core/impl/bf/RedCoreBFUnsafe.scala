package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreBFUnsafe extends CoreBF with RedCore[FString] {

  def rmov(s: Int, d: Int): FString = mk(cclr(d), radd(s, d))

  def rswap(d1: Int, d2: Int): FString = mk(add1(d1, -1), add1(d2, d1), add1(-1, d2))

  def radd(s: Int, d: Int): FString = mk(addt(s, d, -1))

  def rsub(s: Int, d: Int): FString = mk(subt(s, d, -1))

  def rmul(s: Int, d: Int): FString = mk(add1(d, -2), rw(-2, "-", radd(s, d)))

  def rmuli(s: Int, d: Int): FString = mk(add1(d, -1), rw(-1, "-", caddi(s, d)))

  def rdiv(s: Int, d: Int): FString = mk(add1(d, -1), rw(-1, addt(s, -2, -3), rw(-2, "-")))

  def rpow(s: Int, d: Int): FString = mk(add1(d, -1))

  def rneg(d: Int): FString = mk(sub1(d, -1), add1(-1, d))

  def rng1(d: Int): FString = mk(caddi(-1, d), rneg(d))

  def rnot(d: Int): FString = mk(caddi(-1, d), rneg(d))

  def req(s: Int, d: Int): FString = mk(add1(d, -2, "+"), sub2(s, -2, -1), add1(-1, s), sub01(-2, d))

  def rne(s: Int, d: Int): FString = mk(add1(d, -2), sub2(s, -2, -1), add1(-1, s), add01(-2, d))

  def rle(s: Int, d: Int): FString = mk(r(-3, "+"), add2(s, -1, -2), add1(-1, s), add1(d, -1, "+"), ge1(d), ge3(d))

  def rlt(s: Int, d: Int): FString = mk(r(-3, "+"), add2(s, -1, -2), add1(-2, s), add1(d, -2), gt1(d), gt3(d))

}
