package io.github.writeonly.resentiment.teapot.engine2

class InstructionsByte extends InstructionsFake {
  override def get(operand: Symbol):Int = m.get(operand).get
}
