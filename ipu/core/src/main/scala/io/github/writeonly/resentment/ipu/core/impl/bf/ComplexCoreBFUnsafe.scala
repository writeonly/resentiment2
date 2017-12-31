package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.common.FString

class ComplexCoreBFUnsafe extends CoreBF with ComplexCore[FString] {

  def cmov(s: Int, d: Int): FString = mk(cclr(d), cadd(s, d))

  def cswap(d1: Int, d2: Int): FString = mk(add1(d1, -1), add1(d2, d1), add1(-1, d2))

  def cadd(s: Int, d: Int): FString = mk(addt(s, d, -1))

  def csub(s: Int, d: Int): FString = mk(subt(s, d, -1))

  def cmul(s: Int, d: Int): FString = mk(add1(d, -2), rw(-2, "-", cadd(s, d)))

  def cmuli(s: Int, d: Int): FString = mk(add1(d, -1), rw(-1, "-", caddi(s, d)))

  def cdiv(s: Int, d: Int): FString = mk(add1(d, -1), rw(-1, addt(s, -2, -3), rw(-2, "-")))

  def cpow(s: Int, d: Int): FString = mk(add1(d, -1))

  def cneg(d: Int): FString = mk(sub1(d, -1), add1(-1, d))

  def cng1(d: Int): FString = mk(caddi(-1, d), cneg(d))

  def cnot(d: Int): FString = mk(caddi(-1, d), cneg(d))

  def ceq(s: Int, d: Int): FString = mk(add1(d, -2, "+"), sub2(s, -2, -1), add1(-1, s), sub01(-2, d))

  def cne(s: Int, d: Int): FString = mk(add1(d, -2), sub2(s, -2, -1), add1(-1, s), add01(-2, d))

  def cle(s: Int, d: Int): FString = mk(r(-3, "+"), add2(s, -1, -2), add1(-1, s), add1(d, -1, "+"), ge1(d), ge3(d))

  def clt(s: Int, d: Int): FString = mk(r(-3, "+"), add2(s, -1, -2), add1(-2, s), add1(d, -2), gt1(d), gt3(d))

}
