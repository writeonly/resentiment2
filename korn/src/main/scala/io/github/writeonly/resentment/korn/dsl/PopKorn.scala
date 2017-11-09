package io.github.writeonly.resentment.korn.dsl

trait PopKorn[K] {
  def ppop : K
  def ppush : K

  def padd : K
  def psub : K
  def pmul : K
  def pdiv : K
  def pmod : K

  def peq : K
  def pne : K
  def plt : K
  def ple : K
  def pgt : K
  def pge : K

  def pneg : K
  def pnot : K
  def pand : K
  def por : K


}


