package io.github.writeonly.resentment.core.impl.bf

case class FString(f : String => String) {
  def apply(s:String): String = f(s)
  def apply(): String = apply("")
}
