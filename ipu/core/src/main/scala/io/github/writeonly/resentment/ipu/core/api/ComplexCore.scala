package io.github.writeonly.resentment.ipu.core.api

trait ComplexCore[F] {
  def cclr(d: Int): F

  def cconst(s: Int, d: Int): F

  def cmov(s: Int, d: Int): F

  def cadd(s: Int, d: Int): F

  def csub(s: Int, d: Int): F

  def cmul(s: Int, d: Int): F

  def cdiv(s: Int, d: Int): F

  def cpow(s: Int, d: Int): F

  def cswap(d1: Int, d2: Int): F

  def cneg(d: Int): F

  def cnot(d: Int): F

  def ceq(s: Int, d: Int): F

  def cne(s: Int, d: Int): F

  def cge(s: Int, d: Int): F

  def cgt(s: Int, d: Int): F
}
