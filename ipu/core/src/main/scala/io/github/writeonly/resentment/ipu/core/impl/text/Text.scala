package io.github.writeonly.resentment.ipu.core.impl.text

case class Text(name: String) {
  def get(seq: Int*): String = name + "(" + seq.mkString(",") + ") "
  def text() = get()
  def text(r: Int) = get(r)
  def text(r: (Int, Int)): String = get(r._1, r._2)
}

object Text {
  implicit def StringOps(name: String): Text = Text(name)
}
