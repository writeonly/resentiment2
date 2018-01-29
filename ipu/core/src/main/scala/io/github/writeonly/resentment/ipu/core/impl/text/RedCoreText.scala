package io.github.writeonly.resentment.ipu.core.impl.text

import io.github.writeonly.resentment.ipu.core.api.RedCore

class RedCoreText extends RedCore[String] {

  import Text._

  override def rnop(): String = "cnop" text

  override def rclr(d: Int): String = "cclr" text d

  override def rset(d: Int): String = "cset" text d

  override def rmovi(r: (Int, Int)): String = "rmovi" text r

  override def rmov(r: (Int, Int)): String = "rmov" text r

  override def rswap(r: (Int, Int)): String = "rswap" text r

  override def radd(r: (Int, Int)): String = "radd" text r

  override def raddi(r: (Int, Int)): String = "raddi" text r

  override def rsub(r: (Int, Int)): String = "rsub" text r

  override def rsubi(r: (Int, Int)): String = "rsubi" text r

  override def rmul(r: (Int, Int)): String = "rmul" text r

  override def rmulc(r: (Int, Int)): String = "rmulc" text r

  override def rmuli(r: (Int, Int)): String = "rmuli" text r

  override def rdiv(r: (Int, Int)): String = "rdiv" text r

  override def rdivc(r: (Int, Int)): String = "rdivc" text r

  override def rdivi(r: (Int, Int)): String = "rdivi" text r

  override def rmod(r: (Int, Int)): String = "rmod" text r

  override def rmodc(r: (Int, Int)): String = "rmodc" text r

  override def rmodi(r: (Int, Int)): String = "rmodi" text r

  override def rpow(r: (Int, Int)): String = "rpow" text r

  override def rpowc(r: (Int, Int)): String = "rpowc" text r

  override def rpowi(r: (Int, Int)): String = "rpowi" text r

  override def rneg(d: Int): String = "rneg" text d

  override def rng1(d: Int): String = "rng1" text d

  override def rnot(d: Int): String = "rnot" text d

  override def rtau(d: Int): String = "rtau" text d

  override def req(r: (Int, Int)): String = "req" text r

  override def reqc(r: (Int, Int)): String = "reqc" text r

  override def reqi(r: (Int, Int)): String = "reqi" text r

  override def rne(r: (Int, Int)): String = "rne" text r

  override def rnec(r: (Int, Int)): String = "rnec" text r

  override def rnei(r: (Int, Int)): String = "rnei" text r

  override def rle(r: (Int, Int)): String = "rle" text r

  override def rlec(r: (Int, Int)): String = "rlec" text r

  override def rlei(r: (Int, Int)): String = "rlei" text r

  override def rlt(r: (Int, Int)): String = "rlt" text r

  override def rltc(r: (Int, Int)): String = "rltc" text r

  override def rlti(r: (Int, Int)): String = "rlti" text r

  override def rmovc(r: (Int, Int)): String = "rmovc" text r

  override def raddc(r: (Int, Int)): String = "raddc" text r

  override def rsubc(r: (Int, Int)): String = "rsubc" text r

  override def rand(r: (Int, Int)): String = "rand" text r

  override def randc(r: (Int, Int)): String = "randc" text r

  override def randi(r: (Int, Int)): String = "randi" text r

  override def ror(r: (Int, Int)): String = "ror" text r

  override def rorc(r: (Int, Int)): String = "rorc" text r

  override def rori(r: (Int, Int)): String = "rori" text r
}
