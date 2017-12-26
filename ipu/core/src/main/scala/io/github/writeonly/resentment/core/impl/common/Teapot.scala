package io.github.writeonly.resentment.core.impl.common

import java.lang.{StringBuilder => JavaStringBuilder}

import io.github.writeonly.resentment.api.{FInterpreter, Interpreter}

class Teapot(f: FInterpreter) {
  val appendable = new JavaStringBuilder

  def apply() : Interpreter = f(appendable.toString.getBytes)()
}
