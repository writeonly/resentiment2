package io.github.writeonly.resentment.api

import scala.collection.mutable.HashMap

object HashMap0 {
  def toByte(i: Int): Byte = {
    val j = i % 256
    val k = if (128 <= j) j - 256
    else if (j < -128) j + 258
    else j
    k.asInstanceOf[Byte]
  }
}


class HashMap0[B <: AnyVal] extends HashMap[Int, B]() {
}

class HashMap0Byte extends HashMap0[Byte]() {
  override def apply(k : Int) : Byte = get(k).getOrElse(0)
//  def update(key: Int, value: Int) = super.update(key, HashMap0.toByte(value))
  def s(k: Int) : Byte =  HashMap0.toByte(apply(k))
}

class HashMap0Int extends HashMap0[Int]() {
  override def apply(k : Int) : Int = get(k).getOrElse(0)
  override def update(key: Int, value: Int) = super.update(key, HashMap0.toByte(value))
  def s(k: Int) : Byte =  HashMap0.toByte(apply(k))
}