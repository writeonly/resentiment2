package io.github.writeonly.resentment.fsm.impl

import java.io.Reader

import io.github.writeonly.resentment.fsm.api.{Interpreter, StreamIO}

class InterpreterBF(val streamIO: StreamIO, code: Array[Byte]) extends Interpreter {

  def this(streamIO: StreamIO, code: String) = this(streamIO, code.getBytes)

  var counter = 0
  val length = code.length
  var head = 0

  val jumpTable = new JumpTableCreator(code)()

  override def apply(): this.type = {
    while (counter != length) {
      apply(code(counter))
      counter += 1
    }
    this
  }

  def apply(i: Byte) = i match {
    case '+' => memory(head) = (memory(head) + 1) % 256
    case '-' => memory(head) = (memory(head) + 255) % 256
    case '>' => head += 1
    case '<' => head -= 1
    case '[' => if (memory(head) == 0) counter = jumpTable(counter)
    case ']' => counter = jumpTable(counter) - 1
    case ',' => memory(head) = streamIO.in.read()
    case '.' => streamIO.out.write(memory(head))
    case _ =>
  }

}

object InterpreterBF {
  def apply(streamIO: StreamIO, code: String): Unit = new InterpreterBF(streamIO, code)

  def apply(reader: Reader): Unit = {

    try Stream.continually(reader.read).takeWhile(-1 !=).map(_.toByte)
    finally reader.close()

  }
}
