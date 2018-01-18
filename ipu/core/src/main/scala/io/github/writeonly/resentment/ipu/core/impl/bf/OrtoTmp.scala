package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

trait OrtoTmp extends Orto {
  override def tmp(r: (Int, Int), t: Int*): FString = dir(r)
}
