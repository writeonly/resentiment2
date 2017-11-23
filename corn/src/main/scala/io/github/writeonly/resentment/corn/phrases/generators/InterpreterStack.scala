package io.github.writeonly.resentment.corn.phrases.generators

import io.github.writeonly.resentment.corn.command._

import scala.collection.mutable

class InterpreterStack extends Interpreter {

  val m = new mutable.HashMap[Int, Int]()

  var p = 0

  def get(symbol: Symbol) = b.get(symbol).get

  def put(symbol:Symbol) = m.put(get(symbol), a)

  def uvar(o: Symbol) = {
    b.put(o, p)
    p += 1
    put(o)
  }

  override def eval(terminal: Command):Unit = terminal match {
    case PairInstruction(left, right) => {
      if (left!= null) partial(left)
      if (right!= null) partial(right)
    }
    case Var(x, symbol) => uvar(symbol)
    case Store(x, symbol) => put(symbol)
    case LoadVar(symbol) => a =  m.get(get(symbol)).get
    case LoadChar(c) => a = c.toInt
    case LoadStr(c) => a = c.toInt
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