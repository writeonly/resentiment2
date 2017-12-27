package io.github.writeonly.resentment.core.impl.bf

import io.github.writeonly.resentment.core.impl.common.{ComplexCoreTeapot, Teapot}
import io.github.writeonly.resentment.fsm.InterpreterBF
import io.github.writeonly.resentment.fsm.api.{FInterpreter, StreamIO}

class FInterpreterBF extends FInterpreter {
  override def apply(code: Array[Byte]) = new InterpreterBF(StreamIO.byteArray(), code)
}

class TeapotBF extends Teapot(new FInterpreterBF)

class ComplexCoreTeapotBF extends ComplexCoreTeapot(new ComplexCoreBFString, new TeapotBF)
