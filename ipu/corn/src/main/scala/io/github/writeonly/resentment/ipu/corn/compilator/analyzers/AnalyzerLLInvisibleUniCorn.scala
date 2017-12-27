package io.github.writeonly.resentment.ipu.corn.compilator.analyzers

import io.github.writeonly.resentment.ipu.corn.notation.{Operators, _}

class AnalyzerLLInvisibleUniCorn extends AnalyzerLL {

  override def parse(text: String): ParseResult[Command] = parseAll(instruction_list, text)

  def instruction_list: Parser[PairInstruction] = (
    instruction ~ instruction_list ^^ { p => PairInstruction(p._1, p._2) }
      | instruction ^^ {
      PairInstruction(_, null)
    })

  def instruction: Parser[Command] = block_operation //| jump_operation
  def block_operation: Parser[BlockOperation] =
    var_operation | store_operation | load_var_operation | load_str_operation | load_char_operation | load_int_operation | unary_operation | binary_operation

  def label: Parser[Symbol] = symbol

  def var_operation: Parser[Var] = Operators.var_operator ~> symbol ^^ {
    Var(null, _)
  }

  def store_operation: Parser[Store] = Operators.store_operator ~> symbol ^^ {
    Store(null, _)
  }

  def load_var_operation: Parser[LoadVar] = Operators.load_var_operator ~> symbol ^^ {
    LoadVar(_)
  }

  def load_str_operation: Parser[LoadStr] = Operators.load_str_operator ~> stringLiteral ^^ {
    LoadStr(_)
  }

  def load_char_operation: Parser[LoadChar] = Operators.load_char_operator ~> char ^^ {
    LoadChar(_)
  }

  def load_int_operation: Parser[LoadInt] = Operators.load_int_operator ~> bigInt ^^ {
    LoadInt(_)
  }

  def unary_operation: Parser[UnaryOperation] = unary_operator ^^ {
    UnaryOperation(_, null)
  }

  def binary_operation: Parser[BinaryOperation] = binary_operator ~ '(' ~ block_instruction_list ~ ')' ^^ {
    a => BinaryOperation(a._1._1._1, null, a._1._2)
  }


  def block_instruction_list: Parser[BlockOperation] = block_operation

  def jump_operation: Parser[JumpOperation] = jump_operator ~ label ^^ { a => JumpOperation(a._1, a._2) }

  def unary_operator: Parser[String] = Operators.unary_operator.r ^^ { a => a }

  def binary_operator: Parser[String] = binary_operator_byte | binary_operator_bit

  def binary_operator_byte: Parser[String] = Operators.binary_operator_byte.r ^^ { a => a }

  def binary_operator_bit: Parser[String] = Operators.binary_operator_bit.r ^^ { a => a }


  def call_operator: Parser[String] = "(CALCN)|(CALC)|(CAL)".r

  def return_operator: Parser[String] = "(RETCN)|(RETC)|(RET)".r

  def jump_operator: Parser[String] = "(JMPCN)|(JMPC)|(JMP)".r


  def bigDecimal: Parser[BigDecimal] = decimalNumber ^^ {
    BigDecimal(_)
  }

  def bigInt: Parser[BigInt] = wholeNumber ^^ {
    BigInt(_)
  }

  def char: Parser[Char] = "'" ~> "\\w".r ~ "'" ^^ {
    _._1.charAt(0)
  }

  //  def char :Parser[Char] = "'" ~> """\w""" ~"'" ^^ { _._1.charAt(0)}
  //  def char :Parser[Char] = "'" ~> """[a-zA-Z]""".r ~"'" ^^ { _._1.charAt(0)}
  def symbol: Parser[Symbol] = "'" ~> ident ^^ {
    Symbol(_)
  }


}
