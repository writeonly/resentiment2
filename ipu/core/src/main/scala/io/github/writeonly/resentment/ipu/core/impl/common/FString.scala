package io.github.writeonly.resentment.ipu.core.impl.common

case class FString(f: String => String) {
  def apply(s: String): String = f(s)

  def apply(): String = apply("")

  override def toString: String = apply()
}
