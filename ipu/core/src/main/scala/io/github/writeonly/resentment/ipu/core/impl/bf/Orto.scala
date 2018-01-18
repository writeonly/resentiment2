package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

trait Orto {
  def tmp(r: (Int, Int), t: Int*): FString

  def dir(r: (Int, Int)): FString

  def cl(r: (Int, Int)): FString

  def im(r: (Int, Int)): FString
}
