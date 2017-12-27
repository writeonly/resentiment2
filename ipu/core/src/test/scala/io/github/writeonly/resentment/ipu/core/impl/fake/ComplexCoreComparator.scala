package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.ipu.core.api.ComplexCore
import io.github.writeonly.resentment.ipu.core.impl.common.ComplexCoreBuffered

class ComplexCoreComparator (buffered: ComplexCoreBuffered, fake: ComplexCoreFake) {
  def apply (f: ComplexCore[Unit] => Unit) = {
    f(buffered)
    f(fake)
    val interpreter = buffered()
    val actual = interpreter.memory
    val expected = fake.memory
    expected.map.foreach(entry => {
      val key = entry._1
      val eValue = entry._2
//      val aValue = actual.map.get(key) match {
//        case Some(v) => v
//        case None => {
//          val expectedString = expected.map.toString
//          val actualString = actual.map.toString
//          throw new IllegalArgumentException(expectedString + " " + actualString)
//        }
//      }
      val aValue = actual(key)
      val requirement = aValue  == eValue
      require (requirement, "key " + key  + " eValue " + eValue  + " aValue " + aValue + " e " + expected.map.toString() + " a " + actual.map.toString())
    })
  }
}
