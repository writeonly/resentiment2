package io.github.writeonly.resentment.ipu.core.impl.wrapper

import io.github.writeonly.resentment.ipu.core.api.RedCore

class RedCoreDsl(core: RedCore[Unit])
    extends RedCoreWrapper[Unit, RedCoreDsl](core) {
  override def apply(f: Unit): RedCoreDsl = this
}
