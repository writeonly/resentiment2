package io.github.writeonly.resentment.ipu.core.api

import io.github.writeonly.resentment.ipu.core.set.{UniCoreControl, _}

trait TopCore[C]
  extends CommonCore[C]
    with TopCoreExpression
    with UniCoreControl[C]
