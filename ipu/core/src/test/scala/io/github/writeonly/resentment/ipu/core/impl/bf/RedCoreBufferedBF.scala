package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.fsm.api.{FInterpreter, StreamIO}
import io.github.writeonly.resentment.fsm.impl.InterpreterBF
import io.github.writeonly.resentment.ipu.core.common.BufferedInterpreter
import io.github.writeonly.resentment.ipu.core.impl.fake.{
  ComplexCoreComparator,
  RedCoreFake
}
import io.github.writeonly.resentment.ipu.core.impl.wrapper.{
  RedCoreBuffered,
  RedCoreToString
}

class FInterpreterBF extends FInterpreter {
  override def apply(code: Array[Byte]) =
    new InterpreterBF(StreamIO.byteArray(), code)
}

class BufferedInterpreterBF extends BufferedInterpreter(new FInterpreterBF)

class RedCoreToStringBF extends RedCoreToString(new RedCoreBFMatch())

class RedCoreBufferedBF
    extends RedCoreBuffered(new RedCoreToStringBF(), new BufferedInterpreterBF)

class ComplexCoreComparatorBF
    extends ComplexCoreComparator(new RedCoreBufferedBF, new RedCoreFake)
