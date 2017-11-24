package io.github.writeonly.resentment.corn.phrases.generators

import io.github.writeonly.resentment.corn.command._

import scala.collection.mutable

class GeneratorPop extends Generator {
  val b = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val out = new StringBuilder

  val m = new mutable.HashMap[Int, Int]()
  var p = 0

  def get(symbol: Symbol) = b.get(symbol).get

  def uvar(o: Symbol) = {
    b.put(o, p)
    p += 1
    ust(o)
  }

  def ust(symbol:Symbol) = m.put(get(symbol), a)

  def uld(o:Symbol) = a =  m.get(get(o)).get
  def uld(o:Char) = a = o.toInt
  def uld(o:String) = a =  o.toInt
  def uld(o:BigDecimal) = a = o.bigDecimal.toBigInteger.intValue()
  def pout() = out.append(a.toChar)

  val partial = new PartialFunction[Command, Unit] {
    override def isDefinedAt(x: Command): Boolean = x != null
    override def apply(v1: Command): Unit = eval(v1)
  }

  override def apply(code: Command): String = {
    eval(code)
    out.toString()
  }

  def eval(terminal: Command):Unit = terminal match {
    case PairInstruction(left, right) => {
      if (left!= null) partial(left)
      if (right!= null) partial(right)
    }
    case Var(_, symbol) => uvar(symbol)
    case Store(_, symbol) => ust(symbol)
    case LoadVar(c) => uld(c)
    case LoadChar(c) => uld(c)
    case LoadDecinal(c) => uld(c)
    case UnaryOperation("OUT", _) => pout()
    case UnaryOperation("NOT", _) => pout()
    case UnaryOperation("NEG", _) => pout()
//    case BinaryOperation("ADD", x1, x2) => (apply(x1) + apply(x2))
//    case BinaryOperation("SUB", x1, x2) => (apply(x1) - apply(x2))
//    case BinaryOperation("MUL", x1, x2) => (apply(x1) * apply(x2))
//    case BinaryOperation("DIV", x1, x2) => (apply(x1) / apply(x2))
//    case BinaryOperation("MOD", x1, x2) => (apply(x1) / apply(x2))
  }



}