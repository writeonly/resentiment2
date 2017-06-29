package io.github.writeonly.resentiment.teapot.parsers


import io.github.writeonly.resentiment.teapot.command._

class BlockParserLRBasic extends BlockParserLR {
  lazy val expression: PackratParser[Command] =
    (expression <~ "+") ~ expr1 ^^ { case lhs ~ rhs => BinaryOperation("+", lhs, rhs) } |
      (expression <~ "-") ~ expr1 ^^ { case lhs ~ rhs => BinaryOperation("-", lhs, rhs) } |
      expr1

  lazy val expr1: PackratParser[Command] =
    (expr1 <~ "*") ~ expr2 ^^ { case lhs ~ rhs => BinaryOperation("*", lhs, rhs) } |
      (expr1 <~ "/") ~ expr2 ^^ { case lhs ~ rhs => BinaryOperation("/", lhs, rhs) } |
      expr2

  lazy val expr2: PackratParser[Command] =
    (expr3 <~ "^") ~ expr2 ^^ { case lhs ~ rhs => BinaryOperation("^", lhs, rhs) } |
      expr3

  lazy val expr3: PackratParser[Command] =
    "(" ~> expression <~ ")" |
      floatingPointNumber ^^ { x => LoadDecinal(BigDecimal(x)) }

  def apply(text: String) = parseAll(expression, text)
}