package io.github.writeonly.resentment.ipu.core.api

import io.github.writeonly.resentment.ipu.core.set._
import io.github.writeonly.resentment.ipu.core.set.UniCoreControl

trait UniCore[C]
  extends CommonCore[C]
    with UniCoreExpression[C]
    with UniCoreControl[C]
