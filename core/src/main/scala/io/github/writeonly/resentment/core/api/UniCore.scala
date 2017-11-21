package io.github.writeonly.resentment.core.api

import io.github.writeonly.resentment.core.set._

trait UniCore[C]
  extends CommonCore[C]
    with UniCoreExpression[C]
    with UniCoreControl[C]
