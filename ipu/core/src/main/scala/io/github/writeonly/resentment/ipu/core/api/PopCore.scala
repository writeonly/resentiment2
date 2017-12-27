package io.github.writeonly.resentment.ipu.core.api

import io.github.writeonly.resentment.ipu.core.set._
import io.github.writeonly.resentment.ipu.core.set.PopCoreExpression

trait PopCore[C]
  extends CommonCore[C]
    with UniCoreVariable[C]
    with PopCoreExpression[C]
