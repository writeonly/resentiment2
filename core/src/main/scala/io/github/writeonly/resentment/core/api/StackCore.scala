package io.github.writeonly.resentment.core.api

import io.github.writeonly.resentment.core.set.{PopCoreExpression, PopCoreNegation, UniCoreVariable}

trait StackCore[C]
  extends UniCoreVariable[C]
  with PopCoreNegation[C]
  with PopCoreExpression[C]
