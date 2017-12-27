package io.github.writeonly.resentment.ipu.core.set

trait PopCoreExpression[C] {
  def ppop(): C

  def ppush(): C

  def padd(): C

  def psub(): C

  def pmul(): C

  def pdiv(): C

  def pmod(): C

  def peq(): C

  def pne(): C

  def plt(): C

  def ple(): C

  def pgt(): C

  def pge(): C

  def pand(): C

  def por(): C
}
