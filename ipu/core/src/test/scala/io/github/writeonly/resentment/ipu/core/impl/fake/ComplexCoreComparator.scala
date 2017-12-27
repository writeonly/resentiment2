package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.impl.common.ComplexCoreBuffered

class ComplexCoreComparator (buffered: ComplexCoreBuffered, fake: ComplexCoreFake) {
  def apply (f: ComplexCore[Unit] => Unit) = {
    f(buffered)
    f(fake)
    val interpreter = buffered.apply()
    val actual = interpreter.memory
    val expected = fake.memory
    expected.map.foreach(entry => {
      val requirement = actual.map(entry._1)  == entry._2
      require (requirement)
    })
  }
}
