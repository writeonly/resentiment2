package io.github.writeonly.resentment.core.impl

import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.core.set.CommonCore

import scala.collection.mutable

abstract class CommonCoreFake(val io : StreamIO) extends CommonCore[Unit] {
  val b = new mutable.HashMap[Symbol, Int]()
  var a = 0
}
