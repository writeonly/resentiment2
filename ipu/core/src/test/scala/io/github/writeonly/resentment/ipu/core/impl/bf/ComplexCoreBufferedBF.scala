package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.fsm.api.{FInterpreter, StreamIO}
import io.github.writeonly.resentment.fsm.impl.InterpreterBF
import io.github.writeonly.resentment.ipu.core.common.BufferedInterpreter
import io.github.writeonly.resentment.ipu.core.impl.fake.{ComplexCoreComparator, ComplexCoreFake}
import io.github.writeonly.resentment.ipu.core.impl.wrapper.{ComplexCoreBuffered, ComplexCoreToString}

class FInterpreterBF extends FInterpreter {
  override def apply(code: Array[Byte]) = new InterpreterBF(StreamIO.byteArray(), code)
}

class BufferedInterpreterBF extends BufferedInterpreter(new FInterpreterBF)

class ComplexCoreToStringBF extends ComplexCoreToString(new ComplexCoreBFSafe())

class ComplexCoreBufferedBF extends ComplexCoreBuffered(new ComplexCoreToStringBF(), new BufferedInterpreterBF)

class ComplexCoreComparatorBF extends ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
