package io.github.writeonly.resentment.fsm.api

import scala.collection.mutable.HashMap

object Memory {
  def toByte(i: Int): Byte = {
    val max = 256
    val half = max / 2
    val j = i % max
    val k = if (half <= j) j - max
    else if (j < -half) j + max
    else j
    k.asInstanceOf[Byte]
  }

  def toByte(b: Boolean): Byte = toInt(b)

  def toInt(o: Boolean): Byte = if (o) 1 else 0

  def toBoolean(b: Byte): Boolean = b != 0

  def toBoolean(b: Int): Boolean = b != 0
}

class Memory {
  private val map = new HashMap[Int, Byte]()

  def update(key: Int, value: Int): Unit = map.update(key, Memory.toByte(value))

  def update(key: Int, value: Boolean): Unit = map.update(key, Memory.toByte(value))

  def s(k: Int): Byte = Memory.toByte(apply(k))

  def apply(k: Int): Byte = map.getOrElse(k, 0)

  override def toString: String = map.toString()

  def foreach[U](f: ((Int, Byte)) => U): Unit = map.foreach(f)

}