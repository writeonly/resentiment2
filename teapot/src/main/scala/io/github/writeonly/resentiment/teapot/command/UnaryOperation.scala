package io.github.writeonly.resentiment.teapot.command

class UnaryOperation(a: Symbol, b: Symbol, c: Symbol) extends Operation {
  def this(a: Symbol, c: Symbol) = this(a,a,c)
}
