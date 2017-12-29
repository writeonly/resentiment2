package io.github.writeonly.resentment.ipu.core.common

import java.lang.{StringBuilder => JavaStringBuilder}

import io.github.writeonly.resentment.fsm.api.{FInterpreter, Interpreter}

class BufferedInterpreter(f: FInterpreter) {
  //FIXME
  val appendable = new JavaStringBuilder

  def apply(): Interpreter = f(appendable.toString.getBytes)()
}
