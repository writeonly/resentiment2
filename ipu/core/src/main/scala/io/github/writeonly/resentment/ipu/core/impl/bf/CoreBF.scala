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

  def mkm(others: FString*): FString = vm.mkf(others)

  def ge1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", rdec(d), rclr(-1))

  def ge2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", rdec(d), rset(-1))

  def ge3(d: Int): FString = hm(-1, "-", ge2(d))

  def gt1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", rinc(d), rclr(-1))

  def gt2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", rinc(d), rset(-1))

  def gt3(d: Int): FString = hm(-1, "-", gt2(d))

  protected def h(i: Int, s: String): FString = h(i, s, 1)

  protected def h(i: Int): FString = h(i, "")

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

  private def sign(i: Int, p: String, n: String): String = if (0 <= i) p else n

  private def signn(i: Int, p: String, n: String): String = sign(i, p, n) * i.abs

  private def sh(i: Int): String = signn(i, ">", "<")

  private def raddi(i: Int): String = signn(i, "+", "-")

  private def rsubi(i: Int): String = signn(i, "-", "+")

  private def jm(s: String*) = vm.mk(s)

  private def jmhs(h: String, s: String) = jm(h, "[", s, "]")

  private def rm(w: Int, pre: String, suf: String, seq: FString*): FString = FString((sep) => jm(h(w, pre)(sep), vm.mkf(seq)(sep), h(w, suf)(sep)))

  private def h(i: Int, s: String, n: Int): FString = FString((_) => {
    val shift = i - head
    head = i
    sh(shift) + s * n
  })

}
