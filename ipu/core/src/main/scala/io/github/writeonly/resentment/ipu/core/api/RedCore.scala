package io.github.writeonly.resentment.ipu.core.api

trait RedCore[F] {
  def rnop(): F

  def rclr(d: Int): F

  def rset(d: Int): F

  def rmov(r: (Int, Int)): F

  def rmovc(r: (Int, Int)): F

  def rmovi(r: (Int, Int)): F

  def rswap(d1: Int, d2: Int): F

  def radd(r: (Int, Int)): F

  def raddc(r: (Int, Int)): F

  def raddi(r: (Int, Int)): F

  def rsub(r: (Int, Int)): F

  def rsubc(r: (Int, Int)): F

  def rsubi(r: (Int, Int)): F

  def rmul(r: (Int, Int)): F

  def rmulc(r: (Int, Int)): F

  def rmuli(r: (Int, Int)): F

  def rdiv(r: (Int, Int)): F

  def rdivc(r: (Int, Int)): F

  def rdivi(r: (Int, Int)): F

  def rmod(r: (Int, Int)): F

  def rmodc(r: (Int, Int)): F

  def rmodi(r: (Int, Int)): F

  def rpow(r: (Int, Int)): F

  def rpowc(r: (Int, Int)): F

  def rpowi(r: (Int, Int)): F

  def rneg(d: Int): F

  def rng1(d: Int): F

  def rnot(d: Int): F

  def rtau(d: Int): F

  def req(r: (Int, Int)): F

  def reqc(r: (Int, Int)): F

  def reqi(r: (Int, Int)): F

  def rne(r: (Int, Int)): F

  def rnec(r: (Int, Int)): F

  def rnei(r: (Int, Int)): F

  def rle(r: (Int, Int)): F

  def rlec(r: (Int, Int)): F

  def rlei(r: (Int, Int)): F

  def rlt(r: (Int, Int)): F

  def rltc(r: (Int, Int)): F

  def rlti(r: (Int, Int)): F

  def rand(r: (Int, Int)): F

  def randc(r: (Int, Int)): F

  def randi(r: (Int, Int)): F

  def ror(r: (Int, Int)): F

  def rorc(r: (Int, Int)): F

  def rori(r: (Int, Int)): F
}
