package io.github.writeonly.resentment.fsm

import java.io.{Reader}

import scala.collection.mutable

class InterpreterBF(code : Array[Byte]) {
  var counter = 0
  var head = 0
  val tape = new mutable.HashMap[Int,Int]()
  val jumpTable = InterpreterBF.createJumpTable(code)

  def apply(i:Byte) = i match {
    case '+' => 
    case '-' =>
    case '>' =>
    case '<' =>
    case '[' =>
    case ']' =>
    case ',' =>
    case '.' =>
  }

}

object InterpreterBF {
  def createJumpTable(code:Array[Byte]): Map[Int,Int] = {
    val result = new mutable.HashMap[Int,Int]()
    val stack = new mutable.Stack[Int]()
    for((x,i) <- code.view.zipWithIndex) {
      x match  {
        case '[' => stack.push(i)
        case ']' =>  {
          val j = stack.pop()
          result(i) = j
          result(j) = i
        }
        case _ =>
      }
    }
    result.toMap
  }

  def apply(code :String):Unit = new InterpreterBF(code.getBytes)

  def apply(reader : Reader):Unit = {

    try Stream.continually(reader.read).takeWhile(-1 !=).map(_.toByte)
    finally reader.close()

  }
}
