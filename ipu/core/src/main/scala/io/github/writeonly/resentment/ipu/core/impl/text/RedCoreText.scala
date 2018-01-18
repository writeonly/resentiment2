package io.github.writeonly.resentment.ipu.core.impl.text

import io.github.writeonly.resentment.ipu.core.api.RedCore

class RedCoreText extends RedCore[String] {

  override def rnop(): String = apply("cnop")

  override def rclr(d: Int): String = apply("cclr", d)

  override def rset(d: Int): String = apply("cset", d)

  override def rmovi(r: (Int, Int)): String = apply("rmovi", r)

  override def rmov(r: (Int, Int)): String = apply("rmov", r)

  override def rswap(r: (Int, Int)): String = apply("rswap", r)

  override def radd(r: (Int, Int)): String = apply("radd", r)

  override def raddi(r: (Int, Int)): String = apply("raddi", r)

  override def rsub(r: (Int, Int)): String = apply("rsub", r)

  override def rsubi(r: (Int, Int)): String = apply("rsubi", r)

  override def rmul(r: (Int, Int)): String = apply("rmul", r)

  override def rmulc(r: (Int, Int)): String = apply("rmulc", r)

  override def rmuli(r: (Int, Int)): String = apply("rmuli", r)

  override def rdiv(r: (Int, Int)): String = apply("rdiv", r)

  override def rdivc(r: (Int, Int)): String = apply("rdivc", r)

  override def rdivi(r: (Int, Int)): String = apply("rdivi", r)

  override def rmod(r: (Int, Int)): String = apply("rmod", r)

  override def rmodc(r: (Int, Int)): String = apply("rmodc", r)

  override def rmodi(r: (Int, Int)): String = apply("rmodi", r)

  override def rpow(r: (Int, Int)): String = apply("rpow", r)

  override def rpowc(r: (Int, Int)): String = apply("rpowc", r)

  override def rpowi(r: (Int, Int)): String = apply("rpowi", r)

  override def rneg(d: Int): String = apply("rneg", d)

  override def rng1(d: Int): String = apply("rng1", d)

  override def rnot(d: Int): String = apply("rnot", d)

  override def rtau(d: Int): String = apply("rtau", d)

  def apply(name: String, seq: Int*): String =
    name + "(" + seq.mkString(",") + ") "

  def apply(name: String, r: (Int, Int)): String = apply(name, r._1, r._2)

  override def req(r: (Int, Int)): String = apply("req", r)

  override def reqc(r: (Int, Int)): String = apply("reqc", r)

  override def reqi(r: (Int, Int)): String = apply("reqi", r)

  override def rne(r: (Int, Int)): String = apply("rne", r)

  override def rnec(r: (Int, Int)): String = apply("rnec", r)

  override def rnei(r: (Int, Int)): String = apply("rnei", r)

  override def rle(r: (Int, Int)): String = apply("rle", r)

  override def rlec(r: (Int, Int)): String = apply("rlec", r)

  override def rlei(r: (Int, Int)): String = apply("rlei", r)

  override def rlt(r: (Int, Int)): String = apply("rlt", r)

  override def rltc(r: (Int, Int)): String = apply("rltc", r)

  override def rlti(r: (Int, Int)): String = apply("rlti", r)

  override def rmovc(r: (Int, Int)): String = apply("rmovc", r)

  override def raddc(r: (Int, Int)): String = apply("raddc", r)

  override def rsubc(r: (Int, Int)): String = apply("rsubc", r)

  override def rand(r: (Int, Int)): String = apply("rand", r)

  override def randc(r: (Int, Int)): String = apply("randc", r)

  override def randi(r: (Int, Int)): String = apply("randi", r)

  override def ror(r: (Int, Int)): String = apply("ror", r)

  override def rorc(r: (Int, Int)): String = apply("rorc", r)

  override def rori(r: (Int, Int)): String = apply("rori", r)
}
