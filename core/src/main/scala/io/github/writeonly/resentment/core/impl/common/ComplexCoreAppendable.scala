package io.github.writeonly.resentment.core.impl.common

import io.github.writeonly.resentment.core.api.ComplexCore

class ComplexCoreAppendable(core:ComplexCore[FString], appendable : Appendable)  extends ComplexCore[Unit] {
  
  def append(f:FString) = appendable.append(f())
  
  override def cconst(s: Int, d: Int) = append(core.cconst(s,d))

  override def cclr(d: Int) = append(core.cclr(d))

  override def cmv(s: Int, d: Int) = append(core.cmv(s,d))

  override def cadd(s: Int, d: Int) = append(core.cadd(s,d))

  override def csub(s: Int, d: Int) = append(core.csub(s,d))

  override def cmul(s: Int, d: Int) = append(core.cmul(s,d))

  override def cdiv(s: Int, d: Int) = append(core.cdiv(s,d))

  override def cpow(s: Int, d: Int) = append(core.cpow(s,d))

  override def cswap(d1: Int, d2: Int) = append(core.cswap(d1,d2))

  override def cneg(d: Int) = append(core.cneg(d))

  override def cnot(d: Int) = append(core.cnot(d))

  override def ceq(s: Int, d: Int) = append(core.ceq(s,d))

  override def cne(s: Int, d: Int) = append(core.cne(s,d))

  override def cge(s: Int, d: Int) = append(core.cge(s,d))

  override def cgt(s: Int, d: Int) = append(core.cgt(s,d))
}
