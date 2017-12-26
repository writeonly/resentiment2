package io.github.writeonly.resentment.core.impl.common

import io.github.writeonly.resentment.api.Interpreter
import io.github.writeonly.resentment.core.api.ComplexCore

class ComplexCoreTeapot(core: ComplexCore[FString], teapot: Teapot)
  extends ComplexCoreAppendable(core, teapot.appendable) {

  def apply() :Interpreter = teapot()

}
