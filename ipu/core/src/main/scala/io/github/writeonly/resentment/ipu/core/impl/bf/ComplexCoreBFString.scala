package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.impl.common.FString

class ComplexCoreBFString extends CoreBF with ComplexCore[FString] {

  def cmov(s: Int, d: Int): FString = mk(cclr(d), add2(s, d, -1), add1(-1, s))

  def cadd(s: Int, d: Int): FString = mk(add2(s, d, -1), add1(-1, s))

  def csub(s: Int, d: Int): FString = if (s != d) mk(sub2(s, d, -1), add1(-1, s)) else cclr(d)

  def cmul(s: Int, d: Int): FString = if (s != d) cmulUnsafe(s, d) else mk(cmov(s, -3), cmulUnsafe(-3, d))

  def cmulUnsafe(s: Int, d: Int): FString = mk(add1(d, -2), rw(-2, "-", add2(s, d, -1), add1(-1, s)))

  def cdiv(s: Int, d: Int): FString = mk(add1(d, -1))

  def cpow(s: Int, d: Int): FString = mk(add1(d, -1))

  def cswap(d1: Int, d2: Int): FString = mk(add1(d1, -1), add1(d2, d1), add1(-1, d2))

  def cneg(d: Int): FString = mk(sub1(d, -1), add1(-1, d))

  def cnot(d: Int): FString = mk(id(-1, d), cneg(d))

  def ceq(s: Int, d: Int): FString = if (s != d) ceqUnsafe(s, d) else mk(cset(d))

  def ceqUnsafe(s: Int, d: Int) : FString = mk(add1(d, -2, "+"), sub2(s, -2, -1), add1(-1, s), sub01(-2, d))

  def cne(s: Int, d: Int): FString = if (s != d) cneUnsafe(s, d) else mk(cclr(d))

  def cneUnsafe(s: Int, d: Int) : FString = mk(add1(d, -2), sub2(s, -2, -1), add1(-1, s), add01(-2, d))

  def cle(s: Int, d: Int): FString = if (s != d) cleUnsafe(s,d) else mk(cset(d))

  def cleUnsafe(s: Int, d: Int) : FString = mk(r(-3, "+"), add2(s, -1, -2), add1(-1, s), add1(d, -1, "+"), ge1(d), ge3(d))

  def clt(s: Int, d: Int): FString = if (s != d) cltUnsafe(s,d) else mk(cclr(d))

  def cltUnsafe(s: Int, d: Int) : FString = mk(r(-3, "+"), add2(s, -1, -2), add1(-2, s), add1(d, -2), gt1(d), gt3(d))
}
