package io.github.writeonly.resentment.ipu.core.impl.common

import io.github.writeonly.resentment.fsm.api.Interpreter
import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreBuffered(core: ComplexCore[FString], buffered: BufferedInterpreter)
  extends ComplexCoreAppendable(core, buffered.appendable) {

  def apply(): Interpreter = buffered()

}
