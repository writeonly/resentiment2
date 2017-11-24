package io.github.writeonly.resentment.corn.phrases.generators

import io.github.writeonly.resentment.core.impl.CommonCoreFake
import io.github.writeonly.resentment.corn.command._

class GeneratorImpl(val e : CommonCoreFake) extends Generator {

  val partial = new PartialFunction[Command, Unit] {
    override def isDefinedAt(x: Command): Boolean = x != null
    override def apply(v1: Command): Unit = eval(v1)
  }

  override def apply(code: Command) = eval(code)

  def eval(terminal: Command):Unit = terminal match {
    case PairInstruction(left, right) => {
      if (left!= null)  partial(left)
      if (right!= null) partial(right)
    }
    case Var(_, symbol) => e.uvar(symbol)
    case Store(_, symbol) => e.ust(symbol)
    case LoadVar(c) => e.uld(c)
    case LoadChar(c) => e.uld(c)
    case UnaryOperation("OUT", _) => e.pout()
    case UnaryOperation("NOT", _) => e.pout()
    case UnaryOperation("NEG", _) => e.pout()
//    case BinaryOperation("ADD", x1, x2) => (apply(x1) + apply(x2))
//    case BinaryOperation("SUB", x1, x2) => (apply(x1) - apply(x2))
//    case BinaryOperation("MUL", x1, x2) => (apply(x1) * apply(x2))
//    case BinaryOperation("DIV", x1, x2) => (apply(x1) / apply(x2))
//    case BinaryOperation("MOD", x1, x2) => (apply(x1) / apply(x2))
  }



}