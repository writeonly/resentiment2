package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.HalfCore

class Corn(core : HalfCore) extends PopCorn[Corn] with UniCorn[Corn] {
  override def ppop: Corn = ???

  override def ppush: Corn = ???

  override def padd: Corn = ???

  override def psub: Corn = ???

  override def pmul: Corn = ???

  override def pdiv: Corn = ???

  override def pmod: Corn = ???

  override def peq: Corn = ???

  override def pne: Corn = ???

  override def plt: Corn = ???

  override def ple: Corn = ???

  override def pgt: Corn = ???

  override def pge: Corn = ???

  override def pneg: Corn = ???

  override def pnot: Corn = ???

  override def pand: Corn = ???

  override def por: Corn = ???

  override def ust(s: Symbol): Corn = ???

  override def uld(s: Symbol): Corn = ???

  override def uld(c: Int): Corn = ???
}
