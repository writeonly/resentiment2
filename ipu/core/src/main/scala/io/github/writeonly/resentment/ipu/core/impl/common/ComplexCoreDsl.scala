package io.github.writeonly.resentment.ipu.core.impl.common

import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreDsl(core: ComplexCore[Unit])
  extends ComplexCoreWrapper[Unit, ComplexCoreDsl](core) {
  override def apply(f: Unit): ComplexCoreDsl = this
}
