package io.github.writeonly.resentment.ipu.corn.notation

object Operators {
  val var_operator = "uvar"
  val store_operator = "ust"
  val load_var_operator = "uldv"
  val load_int_operator = "uldi"
  val load_str_operator = "ulds"
  val load_char_operator = "uldc"

  val unary_operator = "(pin)|(pout)|(pnot)|(pneg)|(png1)"
  val binary_operator_byte = "(ADD)|(SUB)|(MUL)|(DIV)|(MOD)"
  val binary_operator_bit = "(AND)|(OR)|(XOR)|(XAND)|(EQ)|(NE)|(LE)|(LT)|(GE)|(GT)|"

}
