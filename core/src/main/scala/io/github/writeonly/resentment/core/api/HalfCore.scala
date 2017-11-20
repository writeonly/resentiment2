package io.github.writeonly.resentment.core.api

import io.github.writeonly.resentment.core.set.{PopCoreExpression, UniCoreControl, UniCoreVariable}

trait HalfCore[C]
  extends PopCoreExpression[C]
  with UniCoreVariable[C]
  with UniCoreControl[C]
