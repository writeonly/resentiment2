package io.github.writeonly.resentment.corn.core

import io.github.writeonly.resentment.core.set.CommonCore

import scala.collection.mutable

abstract class Core extends CommonCore[Unit] {
  val b = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val out = new StringBuilder

  def uld(o:Char)
  def uld(o:String)
}
