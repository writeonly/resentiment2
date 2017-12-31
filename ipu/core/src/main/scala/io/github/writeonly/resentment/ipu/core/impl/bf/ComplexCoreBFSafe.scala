package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.common.FString

class ComplexCoreBFSafe(core: ComplexCoreBFUnsafe) extends ComplexCore[FString] {

  def this() = this(new ComplexCoreBFUnsafe)

  override def cnop(): FString = core.cnop()

  override def cclr(d: Int): FString = core.cclr(d)

  override def cset(d: Int): FString = core.cset(d)

  override def cmovi(s: Int, d: Int): FString = core.cmovi(s, d)

  override def cmov(s: Int, d: Int): FString = if (s != d) core.cmov(s, d) else cnop()

  override def cswap(d1: Int, d2: Int): FString = if (d1 != d2) core.cswap(d1, d2) else cnop()

  override def cadd(s: Int, d: Int): FString = if (s != d) core.cadd(s, d) else core.mk(cmovi(2, -3), core.cmul(-3, d))

  override def caddi(s: Int, d: Int): FString = core.caddi(s, d)

  override def csub(s: Int, d: Int): FString = if (s != d) core.csub(s, d) else cclr(d)

  override def csubi(s: Int, d: Int): FString = core.csubi(s, d)

  override def cmul(s: Int, d: Int): FString = if (s != d) core.cmul(s, d) else core.mk(cmov(s, -3), core.cmul(-3, d))

  override def cmuli(s: Int, d: Int): FString = core.cmuli(s, d)

  override def cdiv(s: Int, d: Int): FString = if (s != d) core.cdiv(s, d) else cset(d)

  override def cpow(s: Int, d: Int): FString = core.cpow(s, d)

  override def cneg(d: Int): FString = core.cneg(d)

  override def cng1(d: Int): FString = core.cng1(d)

  override def cnot(d: Int): FString = core.cnot(d)

  override def ceq(s: Int, d: Int): FString = if (s != d) core.ceq(s, d) else cset(d)

  override def cne(s: Int, d: Int): FString = if (s != d) core.cne(s, d) else cclr(d)

  override def cle(s: Int, d: Int): FString = if (s != d) core.cle(s, d) else cset(d)

  override def clt(s: Int, d: Int): FString = if (s != d) core.clt(s, d) else cclr(d)

}
