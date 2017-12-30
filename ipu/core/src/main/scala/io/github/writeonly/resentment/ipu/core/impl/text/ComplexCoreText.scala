package io.github.writeonly.resentment.ipu.core.impl.text

import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreText extends ComplexCore[String] {
  def apply(name: String, seq: Int*): String = name + seq

  override def cnop(): String = apply("cnop")

  override def cclr(d: Int): String = apply("cclr", d)

  override def cset(d: Int): String = apply("cset", d)

  override def cmovi(s: Int, d: Int): String = apply("cmovi", s, d)

  override def cmov(s: Int, d: Int): String = apply("cmov", s, d)

  override def cswap(d1: Int, d2: Int): String = apply("cswap", d1, d2)

  override def cadd(s: Int, d: Int): String = apply("cadd", s, d)

  override def caddi(s: Int, d: Int): String = apply("caddi", s, d)

  override def csub(s: Int, d: Int): String = apply("csub", s, d)

  override def csubi(s: Int, d: Int): String = apply("csubi", s, d)

  override def cmul(s: Int, d: Int): String = apply("cmul", s, d)

  override def cmuli(s: Int, d: Int): String = apply("cmuli", s, d)

  override def cdiv(s: Int, d: Int): String = apply("cdiv", s, d)

  override def cpow(s: Int, d: Int): String = apply("cpow", s, d)

  override def cneg(d: Int): String = apply("cneg", d)

  override def cng1(d: Int): String = apply("cng1", d)

  override def cnot(d: Int): String = apply("not", d)

  override def ceq(s: Int, d: Int): String = apply("ceq", s, d)

  override def cne(s: Int, d: Int): String = apply("cne", s, d)

  override def cle(s: Int, d: Int): String = apply("cle", s, d)

  override def clt(s: Int, d: Int): String = apply("clt", s, d)
}
