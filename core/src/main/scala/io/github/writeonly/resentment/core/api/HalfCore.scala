package io.github.writeonly.resentment.core.api

import io.github.writeonly.resentment.core.set.{CommonCore, PopCoreExpression, UniCoreControl, UniCoreVariable}

trait HalfCore[C]
  extends CommonCore[C]
  with PopCoreExpression[C]
  with UniCoreControl[C]
