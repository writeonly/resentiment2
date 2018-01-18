package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.fsm.api.Interpreter
import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.BufferedInterpreter

class RedCoreBuffered(core: RedCore[String], buffered: BufferedInterpreter)
    extends RedCoreAppendable(core, buffered.appendable) {

  def apply(): Interpreter = buffered()

  override def toString: String = buffered.toString
}
