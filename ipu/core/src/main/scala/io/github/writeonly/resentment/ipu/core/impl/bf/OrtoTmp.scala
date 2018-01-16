package io.github.writeonly.resentment.ipu.core.impl.bf
import io.github.writeonly.resentment.ipu.core.common.FString

trait OrtoTmp extends Orto {
  override def tmp(s: Int, d: Int, t: Int*): FString = dir(s, d)

}
