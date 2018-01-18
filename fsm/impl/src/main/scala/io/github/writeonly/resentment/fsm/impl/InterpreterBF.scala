package io.github.writeonly.resentment.fsm.impl

import java.io.Reader

import com.google.common.base.MoreObjects
import io.github.writeonly.resentment.fsm.api.{Interpreter, StreamIO}

class InterpreterBF(val streamIO: StreamIO,
                    code: Array[Byte],
                    maxWatchdog: Int = 10000000)
    extends Interpreter {

  val length = code.length
  val jumpTable = new JumpTableCreator(code)()
  var counter = 0
  var head = 0
  var watchdog = 0

  def this(streamIO: StreamIO, code: String, maxWatchdog: Int) =
    this(streamIO, code.getBytes, maxWatchdog)

  def this(streamIO: StreamIO, code: String) = this(streamIO, code.getBytes)

  override def apply(): this.type = {
    while (counter != length) {
      require(watchdog < maxWatchdog, this)
      apply(code(counter))
      counter += 1
      watchdog += 1
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
    case _   =>
  }

  override def toString: String =
    MoreObjects
      .toStringHelper(this)
      .add("code", new String(code))
      .add("counter", counter)
      .add("head", head)
      .toString

}

object InterpreterBF {
  def apply(streamIO: StreamIO, code: String): Unit =
    new InterpreterBF(streamIO, code)

  def apply(reader: Reader): Unit = {

    try Stream.continually(reader.read).takeWhile(-1 !=).map(_.toByte)
    finally reader.close()

  }
}
