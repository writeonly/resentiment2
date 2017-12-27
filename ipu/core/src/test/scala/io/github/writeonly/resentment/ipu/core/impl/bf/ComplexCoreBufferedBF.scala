package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.fsm.api.{FInterpreter, StreamIO}
import io.github.writeonly.resentment.fsm.impl.InterpreterBF
import io.github.writeonly.resentment.ipu.core.impl.common.{BufferedInterpreter, ComplexCoreBuffered}
import io.github.writeonly.resentment.ipu.core.impl.fake.{ComplexCoreComparator, ComplexCoreFake}

class FInterpreterBF extends FInterpreter {
  override def apply(code: Array[Byte]) = new InterpreterBF(StreamIO.byteArray(), code)
}

class BufferedInterpreterBF extends BufferedInterpreter(new FInterpreterBF)

class ComplexCoreBufferedBF extends ComplexCoreBuffered(new ComplexCoreBFString, new BufferedInterpreterBF)

class ComplexCoreComparatorBF extends ComplexCoreComparator(new ComplexCoreBufferedBF, new ComplexCoreFake)
