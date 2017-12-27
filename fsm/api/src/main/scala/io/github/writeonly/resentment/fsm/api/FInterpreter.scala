package io.github.writeonly.resentment.fsm.api

trait FInterpreter {
  def apply(code: Array[Byte]): Interpreter
}
