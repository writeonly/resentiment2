package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class CoreBF {

  var head = 0

  val vm = new CodeValidatorMagic

  def r(i: Int, s: String, n: Int): FString = FString((_) => {
    val shift = i - head
    head = i
    sh(shift) + s * n
  })

  def sign(i: Int, p: String, n: String): String = if (0 <= i) p else n

  def signn(i: Int, p: String, n: String): String = sign(i, p, n) * i.abs

  def sh(i: Int): String = signn(i, ">", "<")

  def raddi(i: Int): String = signn(i, "+", "-")

  def rsubi(i: Int): String = signn(i, "-", "+")

  def r(i: Int, s: String): FString = r(i, s, 1)

  def r(i: Int): FString = r(i, "")

  def rm(w: Int, pre: String, suf: String, seq: FString*): FString = FString((sep) => join(r(w, pre)(sep), mk(seq: _*)(sep), r(w, suf)(sep)))

  def rw(w: Int, in: String, out: String, n: Int, seq: FString*): FString = FString((sep) => join(r(w)(sep), "[", mk(seq: _*)(sep), r(w, in)(sep), "]", out * n))

  def rw(w: Int, in: String, out: String, seq: FString*): FString = rw(w, in, out, 1, seq: _*)

  def rw(w: Int, in: String, seq: FString*): FString = rw(w, in, "", seq: _*)

  def rw(w: Int, seq: FString*): FString = rw(w, "", seq: _*)

  def mk(others: FString*): FString = FString((it) => others.map(f => f(it)).mkString(""))

  def join(s: String*) = vm(s.mkString(""))

  def add1(s: Int, d1: Int, out: String): FString = rw(s, "-", out, r(d1, "+"))

  def add1(s: Int, d1: Int): FString = add1(s, d1, "")

  def add01(s: Int, d1: Int): FString = rw(s, "[-]", r(d1, "+"))

  def sub1(s: Int, d1: Int): FString = rw(s, "-", r(d1, "-"))

  def sub01(s: Int, d1: Int): FString = rw(s, "[-]", r(d1, "-"))

  def add2(s: Int, d1: Int, d2: Int): FString = rw(s, "-", r(d1, "+"), r(d2, "+"))

  def sub2(s: Int, d1: Int, d2: Int): FString = rw(s, "-", r(d1, "-"), r(d2, "+"))

  def addt(s: Int, d: Int, t: Int): FString = mk(add2(s, d, t), add1(t, s))

  def subt(s: Int, d: Int, t: Int): FString = mk(sub2(s, d, t), add1(t, s))

  def rclr(d: Int): FString = rmovi(0, d: Int)

  def rset(d: Int): FString = rmovi(1, d: Int)

  def rmovi(s: Int, d: Int): FString = rw(d, "-", raddi(s))

  def ge1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", r(d, "-"), rclr(-1))

  def ge2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", r(d, "-"), rset(-1))

  def ge3(d: Int): FString = rw(-1, "-", ge2(d))

  def gt1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", r(d, "+"), rclr(-1))

  def gt2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", r(d, "+"), rset(-1))

  def gt3(d: Int): FString = rw(-1, "-", gt2(d))

}
