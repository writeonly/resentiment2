package io.github.writeonly.resentiment.teapot.parsers

import io.github.writeonly.resentiment.teapot.command._


class BlockParserLRForth extends BlockParserLR {

  lazy val instruction : PackratParser[Command] = store

  lazy val store :PackratParser[Store] = block_operation ~ "ST" ~ symbol ^^ { a => Store(a._1._1, a._2)}

  lazy val block_operation :PackratParser[Command] =  bt |load| unary_operation | binary_operation


  lazy val load :PackratParser[LoadVariable] = "LD" ~> symbol ^^  { i => LoadVariable(i)}

  lazy val bt :PackratParser[Word] = "BT" ~> bigInt ^^  { i => Word(Array[Byte](i.bigInteger.byteValue()))}

  lazy val unary_operation : PackratParser[UnaryOperation] = block_operation ~ unary_operator ^^ {
    a => UnaryOperation(a._2, a._1)
  }

  lazy val unary_operator : PackratParser[String] = "(NOT)|(IN)|(OUT)" ^^ {a=>a}

  lazy val binary_operation : PackratParser[BinaryOperation] = block_operation ~ block_operation ~ binary_operator ^^ {
    a => BinaryOperation(a._2, a._1._1, a._1._2)
  }

  lazy val  binary_operator :Parser[String] = binary_operator_byte | binary_operator_bit
  lazy val  binary_operator_byte :Parser[String]= "(ADD)|(SUB)|(MUL)|(DIV)|(MOD)" ^^ {a=>a}
  lazy val  binary_operator_bit :Parser[String]= "(AND)|(OR)|(XOR)|(XAND)|(LE)|(LS)|(EQ)|(NE)" ^^ {a=>a}

  lazy val  bigDecimal :PackratParser[BigDecimal]=  decimalNumber ^^ { BigDecimal(_)}
  lazy val  bigInt :PackratParser[BigInt]=  wholeNumber ^^ { BigInt(_)}
  lazy val  symbol :PackratParser[Symbol] = "'" ~> ident ^^ { Symbol(_)}


  def apply(text : String) = parseAll(instruction, text)
}
