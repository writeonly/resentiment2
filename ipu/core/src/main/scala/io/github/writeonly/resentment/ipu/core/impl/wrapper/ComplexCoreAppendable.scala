package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreAppendable(core: ComplexCore[String], appendable: Appendable)
  extends ComplexCoreWrapper[String, Unit](core) {

  override def apply(f: String): Unit = appendable.append(f)
}
