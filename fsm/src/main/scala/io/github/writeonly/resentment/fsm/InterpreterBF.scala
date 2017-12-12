package io.github.writeonly.resentment.fsm

import java.io.{Reader}

import scala.collection.mutable

class InterpreterBF(val streamIO: StreamIO, code : Array[Byte]) {

  def this(streamIO:StreamIO, code:String) = this(streamIO, code.getBytes)

  var counter = 0
  var length = code.length
  var head = 0
  val tape = new mutable.HashMap[Int,Int]() {
    override def apply(k : Int) : Int = get(k).getOrElse(0)
    def s(k: Int) : Int =  if (apply(k) <= 128) apply(k) else apply(k) - 256
  }

  val jumpTable = InterpreterBF.createJumpTable(code)

  def apply(): InterpreterBF = {
    while (counter != length) {
      apply(code(counter))
      counter += 1
    }
    this
  }

  def apply(i:Byte) = i match {
    case '+' => tape(head) = (tape(head) + 1) % 256
    case '-' => tape(head) = (tape(head) + 255) % 256
    case '>' => head += 1
    case '<' => head -= 1
    case '[' => if (tape(head) == 0) counter = jumpTable(counter)
    case ']' => counter = jumpTable(counter) -1
    case ',' => tape(head) = streamIO.in.read()
    case '.' => streamIO.out.write(tape(head))
    case _ =>
  }

}

object InterpreterBF {
  def createJumpTable(code:Array[Byte]): Map[Int,Int] = {
    val result = new mutable.HashMap[Int,Int]()
    val stack = new mutable.Stack[Int]()
    for((x,i) <- code.view.zipWithIndex) apply(result, stack, i, x)
    result.toMap
  }

  def apply(result :mutable.HashMap[Int,Int], stack :mutable.Stack[Int], i :Int, x :Byte) = x match {
    case '[' => stack.push(i)
    case ']' => pop(result, stack, i)
    case _ =>
  }

  def pop(result :mutable.HashMap[Int,Int], stack :mutable.Stack[Int], i:Int): Unit = {
    val j = stack.pop()
    result(i) = j
    result(j) = i
  }

  def apply(streamIO: StreamIO, code :String):Unit = new InterpreterBF(streamIO, code.getBytes)

  def apply(reader : Reader):Unit = {

    try Stream.continually(reader.read).takeWhile(-1 !=).map(_.toByte)
    finally reader.close()

  }
}
