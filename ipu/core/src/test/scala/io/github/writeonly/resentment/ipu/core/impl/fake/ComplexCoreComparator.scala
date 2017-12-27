package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.impl.common.ComplexCoreTeapot

class ComplexCoreComparator (wrapper: ComplexCoreTeapot, fake: ComplexCoreFake) {
  def apply (f: ComplexCore[Unit] => Unit) = {
    f(wrapper)
    f(fake)
    val interpreter = wrapper.apply()
    val aMemory = interpreter.memory
    val eMemory = fake.memory
    eMemory.map.foreach(entry => {
      val requirement = aMemory.map(entry._1)  == entry._2
      require (requirement)
    })

  }
}
