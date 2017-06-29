package io.github.writeonly.resentiment.teapot.compilers

import io.github.writeonly.resentiment.teapot.command._
import io.github.writeonly.resentiment.teapot.parsers.BlockParserLRBasic

class Calculator {
  def resolve(terminal: Command): BigDecimal = terminal match {
    case LoadDecinal(x) => x
//    case BinaryOperation("^", x1, x2) => (math.pow(resolve(x1).p, resolve(x2)))
    case BinaryOperation("+", x1, x2) => (resolve(x1) + resolve(x2))
    case BinaryOperation("-", x1, x2) => (resolve(x1) - resolve(x2))
    case BinaryOperation("*", x1, x2) => (resolve(x1) * resolve(x2))
    case BinaryOperation("/", x1, x2) => (resolve(x1) / resolve(x2))
  }



  def parse(text: String) = new BlockParserLRBasic().apply(text).get
  def evaluate(text: String): BigDecimal = resolve(parse(text))
}