package io.github.writeonly.resentment.core.impl

import scala.collection.mutable

class Fake {
  val symbols = new mutable.HashMap[Symbol, Int]
  var accumulator = 0
  val stack = new mutable.HashMap[Int, Byte]()
  var topPointer = 0
  var basePointer = 0

  def get(symbol: Symbol) = symbols.get(symbol).get
}
