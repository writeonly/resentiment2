package io.github.writeonly.resentment.ipu.core.impl.common

import io.github.writeonly.resentment.fsm.api.Interpreter
import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreTeapot(core: ComplexCore[FString], teapot: Teapot)
  extends ComplexCoreAppendable(core, teapot.appendable) {

  def apply(): Interpreter = teapot()

}
