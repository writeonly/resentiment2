package io.github.writeonly.resentment.ipu.core.impl.text

import io.github.writeonly.resentment.ipu.core.api.RedCore

class RedCoreText extends RedCore[String] {

  override def rnop(): String = apply("cnop")

  override def rclr(d: Int): String = apply("cclr", d)

  override def rset(d: Int): String = apply("cset", d)

  override def rmovi(s: Int, d: Int): String = apply("rmovi", s, d)

  override def rmov(s: Int, d: Int): String = apply("rmov", s, d)

  override def rswap(d1: Int, d2: Int): String = apply("rswap", d1, d2)

  override def radd(s: Int, d: Int): String = apply("radd", s, d)

  override def raddi(s: Int, d: Int): String = apply("raddi", s, d)

  override def rsub(s: Int, d: Int): String = apply("rsub", s, d)

  override def rsubi(s: Int, d: Int): String = apply("rsubi", s, d)

  override def rmul(s: Int, d: Int): String = apply("rmul", s, d)

  override def rmulc(s: Int, d: Int): String = apply("rmulc", s, d)

  override def rmuli(s: Int, d: Int): String = apply("rmuli", s, d)

  override def rdiv(s: Int, d: Int): String = apply("rdiv", s, d)

  override def rdivc(s: Int, d: Int): String = apply("rdivc", s, d)

  override def rdivi(s: Int, d: Int): String = apply("rdivi", s, d)

  override def rmod(s: Int, d: Int): String = apply("rmod", s, d)

  override def rmodc(s: Int, d: Int): String = apply("rmodc", s, d)

  override def rmodi(s: Int, d: Int): String = apply("rmodi", s, d)

  override def rpow(s: Int, d: Int): String = apply("rpow", s, d)

  override def rpowc(s: Int, d: Int): String = apply("rpowc", s, d)

  override def rpowi(s: Int, d: Int): String = apply("rpowi", s, d)

  override def rneg(d: Int): String = apply("rneg", d)

  override def rng1(d: Int): String = apply("rng1", d)

  override def rnot(d: Int): String = apply("rnot", d)

  override def rtau(d: Int): String = apply("rtau", d)

  def apply(name: String, seq: Int*): String = name + "(" + seq.mkString(",") + ") "

  override def req(s: Int, d: Int): String = apply("req", s, d)

  override def reqc(s: Int, d: Int): String = apply("reqc", s, d)

  override def reqi(s: Int, d: Int): String = apply("reqi", s, d)

  override def rne(s: Int, d: Int): String = apply("rne", s, d)

  override def rnec(s: Int, d: Int): String = apply("rnec", s, d)

  override def rnei(s: Int, d: Int): String = apply("rnei", s, d)

  override def rle(s: Int, d: Int): String = apply("rle", s, d)

  override def rlec(s: Int, d: Int): String = apply("rlec", s, d)

  override def rlei(s: Int, d: Int): String = apply("rlei", s, d)

  override def rlt(s: Int, d: Int): String = apply("rlt", s, d)

  override def rltc(s: Int, d: Int): String = apply("rltc", s, d)

  override def rlti(s: Int, d: Int): String = apply("rlti", s, d)

  override def rmovc(s: Int, d: Int): String = apply("rmovc", s, d)

  override def raddc(s: Int, d: Int): String = apply("raddc", s, d)

  override def rsubc(s: Int, d: Int): String = apply("rsubc", s, d)

  override def rand(s: Int, d: Int): String = apply("rand", s, d)

  override def randc(s: Int, d: Int): String = apply("randc", s, d)

  override def randi(s: Int, d: Int): String = apply("randi", s, d)

  override def ror(s: Int, d: Int): String = apply("ror", s, d)

  override def rorc(s: Int, d: Int): String = apply("rorc", s, d)

  override def rori(s: Int, d: Int): String = apply("rori", s, d)
}
