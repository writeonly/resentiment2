package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

trait CodeValidator extends Function[String, String] {
  override def apply(code: String) = {
    require(valid(code), code)
    code
  }

  def valid(code: String): Boolean

  def count(code: String, c: Char) = code.count(_ == c)

  def pair(code: String, l: Char, r: Char) = count(code, l) == count(code, r)

  def mkString(s: Seq[String]) = apply(s.mkString(""))

  def mkFString(others: Seq[FString]): FString = FString((it) => mkString(others.map(f => f(it))))

}

class CodeValidatorMagic extends CodeValidator {
  override def valid(code: String) = pair(code, '[', ']')
}

class CodeValidatorStrict extends CodeValidatorMagic {
  override def valid(code: String) = super.valid(code) && pair(code, '<', '>')
}
