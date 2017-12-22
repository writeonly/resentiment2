package io.github.writeonly.resentment.api

trait FInterpreter {
  def apply(code : Array[Byte]) : Interpreter
}
