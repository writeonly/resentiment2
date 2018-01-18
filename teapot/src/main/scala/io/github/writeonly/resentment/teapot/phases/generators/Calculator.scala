package io.github.writeonly.resentment.teapot.phases.generators

import io.github.writeonly.resentment.ipu.corn.notation._
import io.github.writeonly.resentment.teapot.phases.analyzers.AnalyzerLRBasic

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
