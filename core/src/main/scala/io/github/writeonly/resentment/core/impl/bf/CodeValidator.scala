package io.github.writeonly.resentment.core.impl.bf

trait CodeValidator extends Function[String, String] {
  override def apply(code: String) = {
    require(valid(code))
    code
  }
  def valid(code: String) : Boolean
  def count(code:String, c : Char) = code.count(_ == c)
  def pair(code:String, l:Char, r:Char) = count(code, l) ==  count(code, r)

}

class CodeValidatorMagic extends CodeValidator {
  override def valid(code: String) = pair(code, '[', ']')
}

class CodeValidatorStrict extends CodeValidatorMagic {
  override def valid(code: String) = super.valid(code) && pair(code, '<', '>')
}
