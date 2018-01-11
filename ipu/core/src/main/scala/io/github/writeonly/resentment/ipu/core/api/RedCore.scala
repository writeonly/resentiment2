package io.github.writeonly.resentment.ipu.core.api

trait RedCore[F] {
  def rnop(): F

  def rclr(d: Int): F

  def rset(d: Int): F

  def rmov(s: Int, d: Int): F

  def rmovc(s: Int, d: Int): F

  def rmovi(s: Int, d: Int): F

  def rswap(d1: Int, d2: Int): F

  def radd(s: Int, d: Int): F

  def raddc(s: Int, d: Int): F

  def raddi(s: Int, d: Int): F

  def rsub(s: Int, d: Int): F

  def rsubc(s: Int, d: Int): F

  def rsubi(s: Int, d: Int): F

  def rmul(s: Int, d: Int): F

  def rmuli(s: Int, d: Int): F

  def rdiv(s: Int, d: Int): F

  def rdivi(s: Int, d: Int): F

  def rpow(s: Int, d: Int): F

  def rpowi(s: Int, d: Int): F

  def rneg(d: Int): F

  def rng1(d: Int): F

  def rnot(d: Int): F

  def rtau(d: Int): F

  def req(s: Int, d: Int): F

  def reqc(s: Int, d: Int): F

  def reqi(s: Int, d: Int): F

  def rne(s: Int, d: Int): F

  def rnec(s: Int, d: Int): F

  def rnei(s: Int, d: Int): F

  def rle(s: Int, d: Int): F

  def rlec(s: Int, d: Int): F

  def rlei(s: Int, d: Int): F

  def rlt(s: Int, d: Int): F

  def rltc(s: Int, d: Int): F

  def rlti(s: Int, d: Int): F
}
