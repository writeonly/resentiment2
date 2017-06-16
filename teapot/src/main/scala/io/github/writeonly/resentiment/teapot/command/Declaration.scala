package io.github.writeonly.resentiment.teapot.command

class Declaration {

}

case class byte (value: Int, operand : Symbol) extends Declaration {
  def this(operand:Symbol) = this(0, operand)
}

class word () extends Declaration {

}


