package io.github.writeonly.resentment.fsm.impl

import com.google.common.base.MoreObjects

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

case class JumpTableCreator(code: Array[Byte], result: mutable.HashMap[Int, Int], stack: mutable.Stack[Int]) {
  def this(code: Array[Byte]) = this(code, new mutable.HashMap[Int, Int](), new mutable.Stack[Int]())

  def this(code: String) = this(code.getBytes)

  def apply(): Map[Int, Int] = {
    for ((x, i) <- code.view.zipWithIndex) {
      Try(apply(i, x)) match {
        case Success(_) =>
        case Failure(e) => throw new IllegalStateException(toString(i), e)
      }
    }
    result.toMap
  }

  private def apply(i: Int, x: Byte) = x match {
    case '[' => stack.push(i)
    case ']' => pop(i)
    case _ =>
  }

  private def pop(i: Int): Unit = {
    val j = stack.pop()
    result(i) = j
    result(j) = i
  }

  def toString(counter: Int): String = MoreObjects.toStringHelper(this)
    .add("code", new String(code))
    .add("counter", counter)
    .add("result", result)
    .add("stack", stack)
    .toString

}
