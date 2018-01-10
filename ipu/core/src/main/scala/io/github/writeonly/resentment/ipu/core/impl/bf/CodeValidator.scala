package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

trait CodeValidator extends Function[String, String] {
  def valid(code: String): Boolean

  def pair(code: String, l: Char, r: Char) = count(code, l) == count(code, r)

  def count(code: String, c: Char) = code.count(_ == c)

  def mkfe(others: Seq[FString], end: FString): FString = mkf(others :+ end)

  def mkf(others: Seq[FString]): FString = FString((it) => mk(others.map(f => f(it))))

  def mk(s: Seq[String]) = apply(s.mkString(""))

  override def apply(code: String) = {
    require(valid(code), code)
    code
  }

}

class CodeValidatorMagic extends CodeValidator {
  override def valid(code: String) = pair(code, '[', ']')
}

class CodeValidatorStrict extends CodeValidatorMagic {
  override def valid(code: String) = super.valid(code) && pair(code, '<', '>')
}
