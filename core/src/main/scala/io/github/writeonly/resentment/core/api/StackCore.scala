package io.github.writeonly.resentment.core.api

import io.github.writeonly.resentment.core.set._

trait StackCore[C]
  extends CommonCore[C]
  with UniCoreVariable[C]
  with PopCoreExpression[C]
