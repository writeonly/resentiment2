package io.github.writeonly.resentment.ipu.core.impl.common

import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreAppendable(core: ComplexCore[FString], appendable: Appendable) extends ComplexCore[Unit] {

  def append(f: FString): Appendable = appendable.append(f())

  override def cconst(s: Int, d: Int): Unit = append(core.cconst(s, d))

  override def cclr(d: Int): Unit = append(core.cclr(d))

  override def cmv(s: Int, d: Int): Unit = append(core.cmv(s, d))

  override def cadd(s: Int, d: Int): Unit = append(core.cadd(s, d))

  override def csub(s: Int, d: Int): Unit = append(core.csub(s, d))

  override def cmul(s: Int, d: Int): Unit = append(core.cmul(s, d))

  override def cdiv(s: Int, d: Int): Unit = append(core.cdiv(s, d))

  override def cpow(s: Int, d: Int): Unit = append(core.cpow(s, d))

  override def cswap(d1: Int, d2: Int): Unit = append(core.cswap(d1, d2))

  override def cneg(d: Int): Unit = append(core.cneg(d))

  override def cnot(d: Int): Unit = append(core.cnot(d))

  override def ceq(s: Int, d: Int): Unit = append(core.ceq(s, d))

  override def cne(s: Int, d: Int): Unit = append(core.cne(s, d))

  override def cge(s: Int, d: Int): Unit = append(core.cge(s, d))

  override def cgt(s: Int, d: Int): Unit = append(core.cgt(s, d))
}
