package io.github.writeonly.resentment.fsm.api

abstract class Interpreter extends HasMemory {
  def apply(): this.type
}
