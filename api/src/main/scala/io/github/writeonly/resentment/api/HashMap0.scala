package io.github.writeonly.resentment.api

import scala.collection.mutable.HashMap

class HashMap0[B <: AnyVal] extends HashMap[Int, B]() {
}

class HashMap0Byte extends HashMap0[Byte]() {
  override def apply(k : Int) : Byte = get(k).getOrElse(0)
}

class HashMap0Int extends HashMap0[Int]() {
  override def apply(k : Int) : Int = get(k).getOrElse(0)
  def s(k: Int) : Int =  if (apply(k) <= 128) apply(k) else apply(k) - 256
}