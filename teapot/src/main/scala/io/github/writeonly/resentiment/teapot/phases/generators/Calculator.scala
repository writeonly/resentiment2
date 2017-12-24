package io.github.writeonly.resentiment.teapot.phases.generators

import io.github.writeonly.resentiment.teapot.phases.analyzers.AnalyzerLRBasic
import io.github.writeonly.resentment.corn.notation._

class Calculator {
  def resolve(terminal: Command): BigDecimal = terminal match {
    case LoadDecinal(x) => x
    //    case BinaryOperation("^", x1, x2) => (math.pow(resolve(x1).p, resolve(x2)))
    case BinaryOperation("+", x1, x2) => (resolve(x1) + resolve(x2))
    case BinaryOperation("-", x1, x2) => (resolve(x1) - resolve(x2))
    case BinaryOperation("*", x1, x2) => (resolve(x1) * resolve(x2))
    case BinaryOperation("/", x1, x2) => (resolve(x1) / resolve(x2))
  }


  def parse(text: String) = new AnalyzerLRBasic().apply(text)

  def evaluate(text: String): BigDecimal = resolve(parse(text))
}