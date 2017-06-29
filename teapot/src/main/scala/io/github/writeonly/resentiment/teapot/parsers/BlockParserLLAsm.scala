package io.github.writeonly.resentiment.teapot.parsers

import io.github.writeonly.resentiment.teapot.command._

class BlockParserLLAsm extends BlockParserLL {

  def apply(text : String) = parseAll(instruction_list, text)
  def instruction_list :Parser[Command] = instruction
  def instruction :Parser[Command] = block_operation | jump_operation
  def block_operation :Parser[BlockOperation] =
    store_operation|load_operation| load_constans_operation| unary_operation | binary_operation

  def label :Parser[Symbol] = symbol

  def store_operation :Parser[Store] = "ST" ~> symbol ^^ {Store(null, _)}
  def load_operation :Parser[LoadVariable] = "LD" ~> symbol ^^ {LoadVariable(_)}
  def load_constans_operation :Parser[LoadInteger] = "BT" ~> bigInt ^^ {LoadInteger(_)}

  def unary_operation :Parser[UnaryOperation] = unary_operator ^^ {UnaryOperation(_, null) }
  def binary_operation :Parser[BinaryOperation] = binary_operator ~ '(' ~ block_instruction_list ~ ')' ^^ {
    a => BinaryOperation(a._1._1._1, null, a._1._2)
  }


  def block_instruction_list :Parser[BlockOperation] = block_operation

  def jump_operation :Parser[JumpOperation] = jump_operator ~ label ^^ {a => JumpOperation(a._1, a._2)}



  def unary_operator :Parser[String] = "(NOT)|(NEG)|(IN)|(OUT)" ^^ { a=>a}
  def binary_operator :Parser[String] = binary_operator_byte | binary_operator_bit
  def binary_operator_byte :Parser[String]= "(ADD)|(SUB)|(MUL)|(DIV)|(MOD)" ^^ {a=>a}
  def binary_operator_bit :Parser[String]= "(AND)|(OR)|(XOR)|(XAND)|(LE)|(LS)|(EQ)|(NE)" ^^ {a=>a}


//  def assign_operator = variable_name':='
  //def assign_out_operator = ['NOT'] variable_name'=>'
  def call_operator :Parser[String]= "(CALCN)|(CALC)|(CAL)"
  def return_operator :Parser[String]= "(RETCN)|(RETC)|(RET)"
  def jump_operator :Parser[String]= "(JMPCN)|(JMPC)|(JMP)"



  def bigDecimal :Parser[BigDecimal]=  decimalNumber ^^ { BigDecimal(_)}
  def bigInt :Parser[BigInt]=  wholeNumber ^^ { BigInt(_)}
  def symbol :Parser[Symbol]= "'" ~> ident ^^ { Symbol(_)}




}
