package io.github.writeonly.resentment.kore

import scala.collection.mutable

class KoreFake extends Kore {
  val m : mutable.Map[Int, Int] = new mutable.HashMap[Int, Int]()

  val s : mutable.Map[String, Int] = new mutable.HashMap[String, Int]()

  override def ust(s: String): Unit = ???

  override def uld(s: String): Unit = ???

  override def uld(c: Int): Unit = ???

  override def padd(): Unit = ???

  override def psub(): Unit = ???

  override def pmul(): Unit = ???

  override def pdiv(): Unit = ???

  override def pmod(): Unit = ???
}
