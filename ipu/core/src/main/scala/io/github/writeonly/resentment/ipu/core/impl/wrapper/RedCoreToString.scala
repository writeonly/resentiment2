package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.RedCore
import io.github.writeonly.resentment.ipu.core.common.FString

class RedCoreToString(core: RedCore[FString])
    extends RedCoreWrapper[FString, String](core) {
  override def apply(f: FString): String = f()

}
