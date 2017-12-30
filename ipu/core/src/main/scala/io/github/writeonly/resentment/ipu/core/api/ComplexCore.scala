package io.github.writeonly.resentment.ipu.core.api

trait ComplexCore[F] {
  def cnop(): F

  def cclr(d: Int): F

  def cset(d: Int): F

  def cmovi(s: Int, d: Int): F

  def cmov(s: Int, d: Int): F

  def cswap(d1: Int, d2: Int): F

  def cadd(s: Int, d: Int): F

  def caddi(s: Int, d: Int): F

  def csub(s: Int, d: Int): F

  def csubi(s: Int, d: Int): F

  def cmul(s: Int, d: Int): F

  def cmuli(s: Int, d: Int): F

  def cdiv(s: Int, d: Int): F

  def cpow(s: Int, d: Int): F

  def cneg(d: Int): F

  def cng1(d: Int): F

  def cnot(d: Int): F

  def ceq(s: Int, d: Int): F

  def cne(s: Int, d: Int): F

  def cle(s: Int, d: Int): F

  def clt(s: Int, d: Int): F
}
