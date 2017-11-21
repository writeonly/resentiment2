package io.github.writeonly.resentment.corn.phrases.generators

import io.github.writeonly.resentment.corn.command._

import scala.collection.mutable

class Interpreter extends Generator {
  val b = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val o = new StringBuilder

  val partial = new PartialFunction[Command, Unit] {
    override def isDefinedAt(x: Command): Boolean = x != null
    override def apply(v1: Command): Unit = eval(v1)
  }

  override def apply(code: Command): String = {
    eval(code)
    o.toString()
  }

  def eval(terminal: Command):Unit = terminal match {
    case PairInstruction(left, right) => {
      if (left!= null)  partial(left)
      if (right!= null) partial(right)
    }
    case Var(x, symbol) => b.put(symbol, a)
    case Store(x, symbol) => b.put(symbol, a)
    case LoadVar(c) => a = b(c)
    case LoadChar(c) => a = c.toInt
    case UnaryOperation("OUT", x) => o.append(a.toChar)
    case UnaryOperation("NOT", x) => o.append(a.toChar)
    case UnaryOperation("NEG", x) => o.append(a.toChar)
    case LoadDecinal(x) => a = x.bigDecimal.toBigInteger.intValue()
//    case BinaryOperation("ADD", x1, x2) => (apply(x1) + apply(x2))
//    case BinaryOperation("SUB", x1, x2) => (apply(x1) - apply(x2))
//    case BinaryOperation("MUL", x1, x2) => (apply(x1) * apply(x2))
//    case BinaryOperation("DIV", x1, x2) => (apply(x1) / apply(x2))
//    case BinaryOperation("MOD", x1, x2) => (apply(x1) / apply(x2))
  }



}