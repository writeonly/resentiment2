package io.github.writeonly.resentiment.teapot.engine2

import io.github.writeonly.resentment.core.impl.UniCoreFake

class InstructionsByte extends UniCoreFake {
  override def get(operand: Symbol):Int = m.get(operand).get
}
