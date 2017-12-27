package io.github.writeonly.resentment.fsm.api

import scala.collection.mutable.HashMap

object Memory {
  def toByte(i: Int): Byte = {
    val j = i % 256
    val k = if (128 <= j) j - 256
    else if (j < -128) j + 258
    else j
    k.asInstanceOf[Byte]
  }

  def toByte(b: Boolean): Byte = toInt(b)

  def toInt(o: Boolean): Byte = if (o) 1 else 0

  def toBoolean(b: Byte): Boolean = b != 0

  def toBoolean(b: Int): Boolean = b != 0
}

class Memory {
  val map = new HashMap[Int, Byte]()

  def apply(k: Int): Byte = map.getOrElse(k, 0)

  def update(key: Int, value: Int) = map.update(key, Memory.toByte(value))

  def update(key: Int, value: Boolean) = map.update(key, Memory.toByte(value))

  def s(k: Int): Byte = Memory.toByte(apply(k))
}