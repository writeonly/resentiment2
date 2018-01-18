package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

trait Orto {
  def tmp(s: Int, d: Int, t: Int*): FString

  def dir(s: Int, d: Int): FString

  def cl(s: Int, d: Int): FString

  def im(s: Int, d: Int): FString
}
