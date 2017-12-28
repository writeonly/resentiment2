package io.github.writeonly.resentment.ipu.core.impl.common

import io.github.writeonly.resentment.ipu.core.api.ComplexCore

class ComplexCoreAppendable(core: ComplexCore[FString], appendable: Appendable)
  extends ComplexCoreWrapper[FString, Unit](core) {

  override def apply(f: FString): Unit = appendable.append(f())
}
