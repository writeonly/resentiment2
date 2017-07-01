package io.github.writeonly.resentiment.teapot.phases.generators

import io.github.writeonly.resentiment.teapot.core._

import scala.collection.mutable

class Interpreter extends Generator {
  val m = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val out = new StringBuilder

  val partial = new PartialFunction[Command, Unit] {
    override def isDefinedAt(x: Command): Boolean = x != null
    override def apply(v1: Command): Unit = eval(v1)
  }

  override def apply(code: Command): String = {
    eval(code)
    out.toString()
  }

  private def eval(terminal: Command):Unit = terminal match {
    case PairInstruction(left, right) => {
      if (left!= null)  partial(left)
      if (right!= null) partial(right)
    }
    case Store(x, symbol) => m.put(symbol, a)
    case LoadChar(c) => a = c.toInt
    case LoadVar(c) => a = m(c)
    case UnaryOperation("OUT", x) => out.append(a.toChar)
    case UnaryOperation("NOT", x) => out.append(a.toChar)
    case UnaryOperation("NEG", x) => out.append(a.toChar)
    case LoadDecinal(x) => a = x.bigDecimal.toBigInteger.intValue()
//    case BinaryOperation("ADD", x1, x2) => (apply(x1) + apply(x2))
//    case BinaryOperation("SUB", x1, x2) => (apply(x1) - apply(x2))
//    case BinaryOperation("MUL", x1, x2) => (apply(x1) * apply(x2))
//    case BinaryOperation("DIV", x1, x2) => (apply(x1) / apply(x2))
//    case BinaryOperation("MOD", x1, x2) => (apply(x1) / apply(x2))
  }



}