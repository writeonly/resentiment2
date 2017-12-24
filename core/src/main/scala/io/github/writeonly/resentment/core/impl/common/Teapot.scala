package io.github.writeonly.resentment.core.impl.common

import java.lang.{StringBuilder => JavaStringBuilder}

import io.github.writeonly.resentment.api.FInterpreter

class Teapot(f: FInterpreter) {
  val appendable = new JavaStringBuilder

  def apply() = f(appendable.toString.getBytes)()
}
