package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.common.FString

class ComplexCoreToString(core: ComplexCore[FString])
  extends ComplexCoreWrapper[FString, String](core) {
  override def apply(f: FString): String = f()
}
