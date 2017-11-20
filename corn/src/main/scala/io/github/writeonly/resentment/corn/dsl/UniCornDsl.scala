package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.UniCore

class UniCornDsl(core : UniCore[Unit]) extends UniCore[UniCornDsl] {
  override def uld(o :Symbol) = {core.uld(o); this}
  override def uld(o :Int) = {core.uld(o); this}
  override def ust(o :Symbol) = {core.ust(o); this}

  override def pneg() = {core.pneg(); this}
  override def pnot() = {core.pneg(); this}
  override def png1() = ???

  override def uadd(o :Symbol) = {core.uadd(o); this}
  override def uadd(o :Int) = {core.uadd(o); this}
  override def usub(o :Symbol) = {core.usub(o); this}
  override def usub(o :Int) = {core.usub(o); this}

  override def umul(o :Symbol) = {core.umul(o); this}
  override def umul(o :Int) = {core.umul(o); this}
  override def udiv(o :Symbol) = {core.udiv(o); this}
  override def udiv(o :Int) = {core.udiv(o); this}
  override def umod(o :Symbol) = {core.umod(o); this}
  override def umod(o :Int) = {core.umod(o); this}

  override def ueq(o: Symbol) = {core.ueq(o); this}
  override def ueq(o: Int) = {core.ueq(o); this}
  override def une(o: Symbol) = {core.une(o); this}
  override def une(o: Int) = {core.une(o); this}
  
  override def uand(o: Symbol) = {core.uand(o); this}
  override def uand(o: Int) = {core.uand(o); this}
  override def uor(o: Symbol) = {core.uor(o); this}
  override def uor(o: Int) = {core.uor(o); this}

  override def ult(o: Symbol) = {core.ult(o); this}
  override def ult(o: Int) = {core.ult(o); this}
  override def ugt(o: Symbol) = {core.ugt(o); this}
  override def ugt(o: Int) = {core.ugt(o); this}

  override def ule(o: Symbol) = {core.ule(o); this}
  override def ule(o: Int) = {core.ule(o); this}
  override def uge(o: Symbol) = {core.ule(o); this}
  override def uge(o: Int) = {core.ule(o); this}

}
