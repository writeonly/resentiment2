package io.github.writeonly.resentment.api

import scala.collection.mutable.HashMap

object Memory {
  def toByte(i: Int): Byte = {
    val j = i % 256
    val k = if (128 <= j) j - 256
    else if (j < -128) j + 258
    else j
    k.asInstanceOf[Byte]
  }
  def toByte(b: Boolean) = toInt(b).asInstanceOf[Byte]

  def toInt(o: Boolean) = if (o) 1 else 0

  def toBoolean(b:Byte) = b != 0

  def toBoolean(b:Int) = b != 0
}

class Memory  {
  val map = new HashMap[Int, Byte]()
  def apply(k : Int) : Byte = map.get(k).getOrElse(0)
  def update(key: Int, value: Int) = map.update(key, Memory.toByte(value))
  def update(key: Int, value: Boolean) = map.update(key, Memory.toByte(value))
  def s(k: Int) : Byte =  Memory.toByte(apply(k))
}