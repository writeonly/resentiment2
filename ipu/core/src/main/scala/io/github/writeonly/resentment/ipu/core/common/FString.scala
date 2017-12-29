package io.github.writeonly.resentment.ipu.core.common

case class FString(f: String => String) {
  def apply(s: String): String = f(s)

  def apply(): String = apply("")

  override def toString: String = apply()
}

object FString {
  def empty = FString(_ => "")
}
