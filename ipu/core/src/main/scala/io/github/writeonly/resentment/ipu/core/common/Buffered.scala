package io.github.writeonly.resentment.ipu.core.common

import java.lang.{StringBuilder => JavaStringBuilder}

class Buffered {
  //FIXME
  val appendable = new JavaStringBuilder

  override def toString: String = appendable.toString
}
