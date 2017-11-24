package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.api.HalfCore

import scala.collection.mutable

class HalfCoreFake extends HalfCore[Unit] {
  val m : mutable.Map[Int, Int] = new mutable.HashMap[Int, Int]()

  val s : mutable.Map[String, Int] = new mutable.HashMap[String, Int]()

  override def uvar(s: Symbol) = ???
  override def ust(s: Symbol): Unit = ???

  override def uld(s: Symbol): Unit = ???
  override def uld(c: Int): Unit = ???
  override def uld(o: Char) = ???
  override def uld(o: String) = ???

  override def pin() = ???
  override def pout() = ???


  override def padd(): Unit = ???

  override def psub(): Unit = ???

  override def pmul(): Unit = ???

  override def pdiv(): Unit = ???

  override def pmod(): Unit = ???

  override def ppop() = ???

  override def ppush() = ???

  override def peq() = ???

  override def pne() = ???

  override def plt() = ???

  override def ple() = ???

  override def pgt() = ???

  override def pge() = ???

  override def pand() = ???

  override def por() = ???

  override def pnot() = ???

  override def pneg() = ???

  override def png1() = ???

}
