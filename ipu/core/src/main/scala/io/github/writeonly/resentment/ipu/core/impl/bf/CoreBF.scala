package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class CoreBF {

  private val vm = new CodeValidatorMagic
  private val vs = new CodeValidatorStrict
  private var head = 0

  def rclr(d: Int): FString = rmovi(0, d)

  def rset(d: Int): FString = rmovi(1, d)

  def rmovi(s: Int, d: Int): FString = mkm(hs(d, "-"), raddi(s, d))

  def raddi(s: Int, d: Int): FString = h(d, raddi(s))

  def raddc(s: Int, d1: Int): FString = hs(s, "-", rinc(d1))

  def rsubi(s: Int, d: Int): FString = h(d, rsubi(s))

  def rsubc(s: Int, d1: Int): FString = hs(s, "-", rdec(d1))

  protected def sign(i: Int, p: String, n: String): String = if (0 <= i) p else n

  protected def signn(i: Int, p: String, n: String): String = sign(i, p, n) * i.abs

  protected def sh(i: Int): String = signn(i, ">", "<")

  protected def raddi(i: Int): String = signn(i, "+", "-")

  protected def rsubi(i: Int): String = signn(i, "-", "+")

  protected def h(i: Int, s: String): FString = h(i, s, 1)

  protected def h(i: Int): FString = h(i, "")

  protected def jm(s: String*) = vm.mk(s)

  protected def jmhs(h: String, s: String) = jm(h, "[", s, "]")

  protected def mkm(others: FString*): FString = vm.mkf(others)

  protected def rm(w: Int, pre: String, suf: String, seq: FString*): FString = FString((sep) => jm(h(w, pre)(sep), vm.mkf(seq)(sep), h(w, suf)(sep)))

  protected def hm(w: Int, in: String, seq: FString*): FString = FString((sep) => jmhs(h(w)(sep), vm.mkfe(seq, h(w, in))(sep)))

  protected def hm(w: Int, seq: FString*): FString = hm(w, "", seq: _*)

  protected def hs(w: Int, in: String, seq: FString*): FString = FString((sep) => jmhs(h(w)(sep), vs.mkfe(seq, h(w, in))(sep)))

  protected def hs(w: Int, seq: FString*): FString = hs(w, "", seq: _*)

  protected def rinc(d: Int): FString = raddi(1, d)

  protected def rdec(d: Int): FString = rsubi(1, d)

  protected def add01(s: Int, d1: Int): FString = hs(s, "[-]", rinc(d1))

  protected def sub01(s: Int, d1: Int): FString = hs(s, "[-]", rdec(d1))

  protected def add2(s: Int, d1: Int, d2: Int): FString = hs(s, "-", rinc(d1), rinc(d2))

  protected def sub2(s: Int, d1: Int, d2: Int): FString = hs(s, "-", rdec(d1), rinc(d2))

  protected def addt(s: Int, d: Int, t: Int): FString = mkm(add2(s, d, t), raddc(t, s))

  protected def subt(s: Int, d: Int, t: Int): FString = mkm(sub2(s, d, t), raddc(t, s))

  protected def ge1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", h(d, "-"), rclr(-1))

  protected def ge2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", h(d, "-"), rset(-1))

  protected def ge3(d: Int): FString = hm(-1, "-", ge2(d))

  protected def gt1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", h(d, "+"), rclr(-1))

  protected def gt2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", h(d, "+"), rset(-1))

  protected def gt3(d: Int): FString = hm(-1, "-", gt2(d))

  private def h(i: Int, s: String, n: Int): FString = FString((_) => {
    val shift = i - head
    head = i
    sh(shift) + s * n
  })


}
