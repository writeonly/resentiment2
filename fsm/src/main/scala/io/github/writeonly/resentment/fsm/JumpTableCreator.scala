package io.github.writeonly.resentment.fsm

import scala.collection.mutable

class JumpTableCreator(code:Array[Byte], result :mutable.HashMap[Int,Int], stack :mutable.Stack[Int]) {
  def this(code:Array[Byte]) = this(code, new mutable.HashMap[Int,Int](), new mutable.Stack[Int]())

  def this(code:String) = this(code.getBytes)


  def apply() :Map[Int, Int] = {
    for((x,i) <- code.view.zipWithIndex) apply(i, x)
    result.toMap
  }

  private def apply(i :Int, x :Byte) = x match {
    case '[' => stack.push(i)
    case ']' => pop(i)
    case _ =>
  }

  private def pop(i:Int): Unit = {
    val j = stack.pop()
    result(i) = j
    result(j) = i
  }
}
