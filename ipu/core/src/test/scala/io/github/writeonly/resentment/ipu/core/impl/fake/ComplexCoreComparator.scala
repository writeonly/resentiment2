package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.impl.common.ComplexCoreBuffered

class ComplexCoreComparator(buffered: ComplexCoreBuffered, fake: ComplexCoreFake) {
  def apply(f: ComplexCore[Unit] => Unit): Unit = {
    f(buffered)
    f(fake)
    val interpreter = buffered()
    val actual = interpreter.memory
    val expected = fake.memory
    expected.foreach(entry => {
      val key = entry._1
      val eValue = entry._2
      val aValue = actual(key)
      val requirement = aValue == eValue
      require(requirement, "key " + key + " eValue " + eValue + " aValue " + aValue + " e " + expected + " a " + actual)
    })
  }
}
