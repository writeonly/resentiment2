package io.github.writeonly.resentiment.teapot.compilers

import io.github.writeonly.resentiment.teapot.command._
import io.github.writeonly.resentiment.teapot.parsers.BlockParserLRBasic

import scala.collection.mutable

class Interpreter {
  val m = new mutable.HashMap[Symbol, Int]()
  var a = 0
  val out = new StringBuilder

  def apply(terminal: Command) = terminal match {
    case Store(x, symbol) => m.put(symbol, a)
    case LoadChar(c) => a = c.toInt
    case UnaryOperation("OUT", x) => out.append(a.toChar)
    case LoadDecinal(x) => x
//    case BinaryOperation("ADD", x1, x2) => (apply(x1) + apply(x2))
//    case BinaryOperation("SUB", x1, x2) => (apply(x1) - apply(x2))
//    case BinaryOperation("MUL", x1, x2) => (apply(x1) * apply(x2))
//    case BinaryOperation("DIV", x1, x2) => (apply(x1) / apply(x2))
//    case BinaryOperation("MOD", x1, x2) => (apply(x1) / apply(x2))
  }

}