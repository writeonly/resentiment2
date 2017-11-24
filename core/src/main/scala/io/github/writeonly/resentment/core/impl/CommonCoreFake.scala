package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.set.CommonCore

import scala.collection.mutable

abstract class CommonCoreFake extends CommonCore[Unit] {
  val b = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val out = new StringBuilder
}
