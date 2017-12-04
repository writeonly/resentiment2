package io.github.writeonly.resentment.fsm

import java.io.{Reader}

import scala.collection.mutable

class InterpreterBF {
  var counter = 0
  var head = 0
  val tape = new mutable.HashMap[Int,Int]()


  def apply(code :String):Unit = apply(code.getBytes)

  def apply(reader : Reader):Unit = {

    try Stream.continually(reader.read).takeWhile(-1 !=).map(_.toByte)
    finally reader.close()
    
  }

  def apply(code : Array[Byte]): Unit = {

  }

  def createJump(code:Array[Byte]): Map[Int,Int] = {
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



  def apply(i:Int) = i match {
    case '+' =>
  }

}
