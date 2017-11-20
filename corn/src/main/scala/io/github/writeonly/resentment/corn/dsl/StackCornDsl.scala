package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.StackCore

class StackCornDsl(core : StackCore[Unit]) extends StackCore[StackCornDsl] {
  def uld(operand :Int) = {core.uld(operand); this}
  def uld(operand :Symbol) = {core.uld(operand); this}
  def ust(operand :Symbol) = {core.ust(operand); this}
  def ppush = {core.ppush; this}

  def padd = {core.padd; this}
  def psub = {core.psub; this}
  def pneg = {core.pneg; this}

  def pmul = {core.pmul; this}
  def pdiv = {core.pdiv; this}
  def pmod = {core.pmod; this}

  override def ppop() = ???

  override def peq() = ???

  override def pne() = ???

  override def plt() = ???

  override def ple() = ???

  override def pgt() = ???

  override def pge() = ???

  override def pand() = ???

  override def por() = ???

  override def pnot() = ???

  override def png1() = ???
}
