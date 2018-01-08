package io.github.writeonly.resentment.ipu.core.impl.fake

import java.lang.{StringBuilder => JavaStringBuilder}

import com.google.common.base.MoreObjects
import io.github.writeonly.resentment.fsm.api.Memory
import io.github.writeonly.resentment.ipu.core.common.BufferedInterpreter
import io.github.writeonly.resentment.ipu.core.impl.text.RedCoreText
import io.github.writeonly.resentment.ipu.core.impl.wrapper._

import scala.util.{Failure, Success, Try}

class ComplexCoreComparator(buffered: RedCoreBuffered, fake: RedCoreFake) {
  def apply(f: RedCoreDsl => Unit): Unit = {
    f(new RedCoreDsl(buffered))
    f(new RedCoreDsl(fake))
    val message = new RedCoreBuffered(new RedCoreText(), new BufferedInterpreter(null))
    f(new RedCoreDsl(message))
    val interpreter = Try(buffered()) match {
      case Success(v) => v
      case Failure(e) => throw new IllegalStateException(message.toString, e)
    }

    val actualMemory = interpreter.memory
    val expectedMemory = fake.memory
    expectedMemory.foreach(entry => {
      TestEntry(entry, expectedMemory, actualMemory, f)
    })
  }
}

case class TestEntry(key: Int, expectedValue: Byte, actualValue: Byte, expectedMemory: Memory, actualMemory: Memory, f: RedCoreDsl => Unit) {

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
    f(new RedCoreDsl(new RedCoreAppendable(new RedCoreText(), appendable)))
    appendable.toString
  }

  def test = require(expectedValue == actualValue, this)
}

object TestEntry {
  def apply(entry: (Int, Byte), expectedMemory: Memory, actualMemory: Memory, f: RedCoreDsl => Unit)
  = new TestEntry(entry._1, entry._2, actualMemory(entry._1), expectedMemory, actualMemory, f)
}