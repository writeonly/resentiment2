package io.github.writeonly.resentment.api

trait Interpreter {
  def apply() : this.type
}
