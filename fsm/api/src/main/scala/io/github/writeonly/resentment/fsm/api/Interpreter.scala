package io.github.writeonly.resentment.fsm.api

abstract class Interpreter {
  val memory = new Memory()

  def apply(): this.type
}
