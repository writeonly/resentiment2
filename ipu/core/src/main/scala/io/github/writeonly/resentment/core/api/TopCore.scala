package io.github.writeonly.resentment.core.api

import io.github.writeonly.resentment.core.set._

trait TopCore[C]
  extends CommonCore[C]
    with TopCoreExpression
    with UniCoreControl[C]
