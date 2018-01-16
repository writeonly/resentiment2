package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class MetaBF {
  protected val inc = "+"
  protected val dec = "-"
  protected val clr = "[-]"

  private val vm = new CodeValidatorMagic
  private val vs = new CodeValidatorStrict
  private var head = 0

  def mkm(seq: FString*): FString = vm.mkf(seq)

  protected def rm(w: Int, pre: String, suf: String, seq: FString*): FString = FString((sep) => jm(h(w, pre)(sep), vm.mkf(seq)(sep), h(w, suf)(sep)))

  protected def h(i: Int, s: String, n: Int): FString = FString((_) => {
    val shift = i - head
    head = i
    sh(shift) + s * n
  })

  protected def h(i: Int, s: String): FString = h(i, s, 1)

  protected def h(i: Int): FString = h(i, "")

  protected def hm(w: Int, in: String, seq: FString*): FString = FString((sep) => jmhs(h(w)(sep), vm.mkfe(seq, h(w, in))(sep)))

  protected def hm(w: Int, seq: FString*): FString = hm(w, "", seq: _*)

  protected def hs(w: Int, in: String, seq: FString*): FString = FString((sep) => jmhs(h(w)(sep), vs.mkfe(seq, h(w, in))(sep)))

  protected def hs(w: Int, seq: FString*): FString = hs(w, "", seq: _*)

  protected def raddi(i: Int): String = signn(i, inc, dec)

  protected def rsubi(i: Int): String = signn(i, dec, inc)

  private def sign(i: Int, p: String, n: String): String = if (0 <= i) p else n

  private def signn(i: Int, p: String, n: String): String = sign(i, p, n) * i.abs

  private def sh(i: Int): String = signn(i, ">", "<")

  private def jm(s: String*) = vm.mk(s)

  private def jmhs(h: String, s: String) = jm(h, "[", s, "]")
}
