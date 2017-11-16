package io.github.writeonly.resentment.corn.dsl

trait PopCorn[C] {
  def ppop : C
  def ppush : C

  def padd : C
  def psub : C
  def pmul : C
  def pdiv : C
  def pmod : C

  def peq : C
  def pne : C
  def plt : C
  def ple : C
  def pgt : C
  def pge : C

  def pneg : C
  def pnot : C
  def pand : C
  def por : C


}


