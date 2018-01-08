package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class CoreBF {

  var head = 0

  val vm = new CodeValidatorMagic

  val vs = new CodeValidatorStrict

  def h(i: Int, s: String, n: Int): FString = FString((_) => {
    val shift = i - head
    head = i
    sh(shift) + s * n
  })

  def sign(i: Int, p: String, n: String): String = if (0 <= i) p else n

  def signn(i: Int, p: String, n: String): String = sign(i, p, n) * i.abs

  def sh(i: Int): String = signn(i, ">", "<")

  def raddi(i: Int): String = signn(i, "+", "-")

  def rsubi(i: Int): String = signn(i, "-", "+")

  def h(i: Int, s: String): FString = h(i, s, 1)

  def h(i: Int): FString = h(i, "")

  def jm(s: String*) = jm0(s)

  private def jm0(s: Seq[String]) = vm.mkString(s)

  private def js0(s: Seq[String]):String = vs.mkString(s)

  def mkm(others: FString*): FString = mkm0(others)

  private def mkm0(others: Seq[FString]): FString = vm.mkFString(others)

  private def mks0(others: Seq[FString]): FString = vs.mkFString(others)

  def rm(w: Int, pre: String, suf: String, seq: FString*): FString = FString((sep) => jm(h(w, pre)(sep), mkm0(seq)(sep), h(w, suf)(sep)))

  def rw(w: Int, in: String, out: String, n: Int, seq: FString*): FString = FString((sep) => jm(h(w)(sep), "[", mkm0(seq)(sep), h(w, in)(sep), "]", out * n))

  def hm(w: Int, in: String, out: String, seq: FString*): FString = rw(w, in, out, 1, seq: _*)

  def hm(w: Int, in: String, seq: FString*): FString = hm(w, in, "", seq: _*)

  def hm(w: Int, seq: FString*): FString = hm(w, "", seq: _*)

  def hs(w: Int, in: String, seq: FString*): FString = FString((sep) => jm(h(w)(sep), "[", mks0(seq :+ h(w, in))(sep), "]"))

  def hs(w: Int, seq: FString*): FString = hs(w, "", seq: _*)

  def add1(s: Int, d1: Int, out: String): FString = mkm(hs(s, "-", h(d1, "+")), h(s, out))

  def add1(s: Int, d1: Int): FString = hs(s, "-", h(d1, "+"))

  def add01(s: Int, d1: Int): FString = hs(s, "[-]", h(d1, "+"))

  def sub1(s: Int, d1: Int): FString = hs(s, "-", h(d1, "-"))

  def sub01(s: Int, d1: Int): FString = hs(s, "[-]", h(d1, "-"))

  def add2(s: Int, d1: Int, d2: Int): FString = hs(s, "-", h(d1, "+"), h(d2, "+"))

  def sub2(s: Int, d1: Int, d2: Int): FString = hs(s, "-", h(d1, "-"), h(d2, "+"))

  def addt(s: Int, d: Int, t: Int): FString = mkm(add2(s, d, t), add1(t, s))

  def subt(s: Int, d: Int, t: Int): FString = mkm(sub2(s, d, t), add1(t, s))

  def rclr(d: Int): FString = rmovi(0, d)

  def rset(d: Int): FString = rmovi(1, d)

  def raddi(s: Int, d: Int): FString = h(d, raddi(s))

  def rmovi(s: Int, d: Int): FString = mkm(hs(d, "-"), raddi(s, d))

  def ge1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", h(d, "-"), rclr(-1))

  def ge2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", h(d, "-"), rset(-1))

  def ge3(d: Int): FString = hm(-1, "-", ge2(d))

  def gt1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", h(d, "+"), rclr(-1))

  def gt2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", h(d, "+"), rset(-1))

  def gt3(d: Int): FString = hm(-1, "-", gt2(d))

}
