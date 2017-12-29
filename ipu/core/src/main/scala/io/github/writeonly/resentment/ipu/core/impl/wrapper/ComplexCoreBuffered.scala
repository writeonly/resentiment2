package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.fsm.api.Interpreter
import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.common.BufferedInterpreter

class ComplexCoreBuffered(core: ComplexCore[String], buffered: BufferedInterpreter)
  extends ComplexCoreAppendable(core, buffered.appendable) {

  def apply(): Interpreter = buffered()
}
