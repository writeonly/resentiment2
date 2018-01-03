package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.RedCore

class RedCoreAppendable(core: RedCore[String], appendable: Appendable)
  extends RedCoreWrapper[String, Unit](core) {

  override def apply(f: String): Unit = appendable.append(f)
}
