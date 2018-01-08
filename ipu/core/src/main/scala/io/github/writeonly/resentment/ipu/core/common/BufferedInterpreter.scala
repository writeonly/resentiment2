package io.github.writeonly.resentment.ipu.core.common

import io.github.writeonly.resentment.fsm.api.{FInterpreter, Interpreter}

class BufferedInterpreter(f: FInterpreter) extends Buffered {

  def apply(): Interpreter = f(appendable.toString.getBytes)()

}
