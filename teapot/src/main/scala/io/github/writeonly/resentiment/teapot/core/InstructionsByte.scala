package io.github.writeonly.resentiment.teapot.core

class InstructionsByte extends InstructionsFake {
  override def get(operand: Symbol):Int = m.get(operand).get
}
