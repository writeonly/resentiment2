package io.github.writeonly.resentment.korn.dsl

import scala.collection.mutable

class KornFake extends Korn {

  val m = new mutable.HashMap[Int, Int]()
  val s = new mutable.HashMap[Symbol, Int]()


  override def ust(s: Symbol): Korn = ???

  override def uld(s: Symbol): Korn = ???

  override def uld(c: Short): Korn = ???

  override def ppop: Korn = ???

  override def ppush: Korn = ???

  override def padd: Korn = ???

  override def psub: Korn = ???

  override def pmul: Korn = ???

  override def pdiv: Korn = ???

  override def pmod: Korn = ???

  override def peq: Korn = ???

  override def pne: Korn = ???

  override def plt: Korn = ???

  override def ple: Korn = ???

  override def pgt: Korn = ???

  override def pge: Korn = ???

  override def pneg: Korn = ???

  override def pnot: Korn = ???

  override def pand: Korn = ???

  override def por: Korn = ???
}
