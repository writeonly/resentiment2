package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.UniCore

class InstructionsDsl(core : UniCore[Unit]) extends UniCore[InstructionsDsl] {
  override def uld(o :Symbol) = {core.uld(o); this}
  override def uld(o :Int) = {core.uld(o); this}
  override def ust(o :Symbol) = {core.ust(o); this}

  override def uadd(o :Symbol) = {core.uadd(o); this}
  override def uadd(o :Int) = {core.uadd(o); this}
  override def usub(o :Symbol) = {core.usub(o); this}
  override def usub(o :Int) = {core.usub(o); this}
  override  def pneg() = {core.pneg(); this}

  override def umul(o :Symbol) = {core.umul(o); this}
  override def umul(o :Int) = {core.umul(o); this}
  override def udiv(o :Symbol) = {core.udiv(o); this}
  override def udiv(o :Int) = {core.udiv(o); this}
  override def umod(o :Symbol) = {core.umod(o); this}
  override def umod(o :Int) = {core.umod(o); this}

  override def ueq(o: Symbol) = ???

  override def ueq(o: Int) = ???

  override def une(o: Symbol) = ???

  override def une(o: Int) = ???

  override def uand(o: Symbol) = ???

  override def uand(o: Int) = ???

  override def uor(o: Symbol) = ???

  override def uor(o: Int) = ???

  override def ult(o: Symbol) = ???

  override def ult(o: Int) = ???

  override def ugt(o: Symbol) = ???

  override def ugt(o: Int) = ???

  override def ule(o: Symbol) = ???

  override def ule(o: Int) = ???

  override def uge(o: Symbol) = ???

  override def uge(o: Int) = ???

  override def pnot() = ???

}
