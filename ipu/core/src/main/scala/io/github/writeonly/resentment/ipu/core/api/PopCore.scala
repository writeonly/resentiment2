package io.github.writeonly.resentment.ipu.core.api

import io.github.writeonly.resentment.ipu.core.set.{PopCoreExpression, _}

trait PopCore[C]
  extends CommonCore[C]
    with UniCoreVariable[C]
    with PopCoreExpression[C]
