package io.github.writeonly.resentment.ipu.core.impl.text

import io.github.writeonly.resentment.ipu.core.api.RedCore

class RedCoreText extends RedCore[String] {
  def apply(name: String, seq: Int*): String = name + seq

  override def rnop(): String = apply("cnop")

  override def rclr(d: Int): String = apply("cclr", d)

  override def rset(d: Int): String = apply("cset", d)

  override def rmovi(s: Int, d: Int): String = apply("cmovi", s, d)

  override def rmov(s: Int, d: Int): String = apply("cmov", s, d)

  override def rswap(d1: Int, d2: Int): String = apply("cswap", d1, d2)

  override def radd(s: Int, d: Int): String = apply("cadd", s, d)

  override def raddi(s: Int, d: Int): String = apply("caddi", s, d)

  override def rsub(s: Int, d: Int): String = apply("csub", s, d)

  override def rsubi(s: Int, d: Int): String = apply("csubi", s, d)

  override def rmul(s: Int, d: Int): String = apply("cmul", s, d)

  override def rmuli(s: Int, d: Int): String = apply("cmuli", s, d)

  override def rdiv(s: Int, d: Int): String = apply("cdiv", s, d)

  override def rpow(s: Int, d: Int): String = apply("cpow", s, d)

  override def rneg(d: Int): String = apply("cneg", d)

  override def rng1(d: Int): String = apply("cng1", d)

  override def rnot(d: Int): String = apply("not", d)

  override def req(s: Int, d: Int): String = apply("ceq", s, d)

  override def rne(s: Int, d: Int): String = apply("cne", s, d)

  override def rle(s: Int, d: Int): String = apply("cle", s, d)

  override def rlt(s: Int, d: Int): String = apply("clt", s, d)
}
