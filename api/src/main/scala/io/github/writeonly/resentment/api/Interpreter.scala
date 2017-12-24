package io.github.writeonly.resentment.api

abstract class Interpreter {
  val memory = new Memory()

  def apply(): this.type
}
