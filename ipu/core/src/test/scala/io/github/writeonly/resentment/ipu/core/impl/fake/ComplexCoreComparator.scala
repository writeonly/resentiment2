package io.github.writeonly.resentment.ipu.core.impl.fake

import java.lang.{StringBuilder => JavaStringBuilder}

import com.google.common.base.MoreObjects
import io.github.writeonly.resentment.fsm.api.Memory
import io.github.writeonly.resentment.ipu.core.impl.wrapper._

class ComplexCoreComparator(buffered: ComplexCoreBuffered, fake: ComplexCoreFake) {
  def apply(f: ComplexCoreDsl => Unit): Unit = {
    f(new ComplexCoreDsl(buffered))
    f(new ComplexCoreDsl(fake))
    val interpreter = buffered()
    val actualMemory = interpreter.memory
    val expectedMemory = fake.memory
    expectedMemory.foreach(entry => {
      TestEntry(entry, expectedMemory, actualMemory, f)
    })
  }
}

case class TestEntry(key: Int, expectedValue: Byte, actualValue: Byte, expectedMemory: Memory, actualMemory: Memory, f: ComplexCoreDsl => Unit) {

  override def toString: String = MoreObjects.toStringHelper(this)
    .add("key", key)
    .add("expectedValue", expectedValue)
    .add("actualValue", actualValue)
    .add("expectedMemory", expectedMemory)
    .add("code", code)
    .toString

  def code: String = {
    //FIXME
    val appendable = new JavaStringBuilder()
    f(new ComplexCoreDsl(new ComplexCoreAppendable(new ComplexCoreText(), appendable)))
    appendable.toString
  }

  def test = require(expectedValue == actualValue, this)
}

object TestEntry {
  def apply(entry: (Int, Byte), expectedMemory: Memory, actualMemory: Memory, f: ComplexCoreDsl => Unit)
  = new TestEntry(entry._1, entry._2, actualMemory(entry._1), expectedMemory, actualMemory, f)
}