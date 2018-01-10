package io.github.writeonly.resentment.ipu.core.common

case class FString(f: String => String) {
  override def toString: String = apply()

  def apply(): String = apply("")

  def apply(s: String): String = f(s)
}

object FString {
  def empty = FString(_ => "")
}
