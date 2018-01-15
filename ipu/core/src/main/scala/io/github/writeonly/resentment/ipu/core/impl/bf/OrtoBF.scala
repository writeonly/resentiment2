package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class OrtoBF extends MetaBF {

  def rclr(d: Int): FString = rmovi(0, d)

  def rset(d: Int): FString = rmovi(1, d)

  def rmovi(s: Int, d: Int): FString = mkm(hs(d, "-"), raddi(s, d))

  def raddc(s: Int, d1: Int): FString = hs(s, "-", rinc(d1))

  def raddi(s: Int, d: Int): FString = h(d, raddi(s))

  def rinc(d: Int): FString = raddi(1, d)

  def rsubc(s: Int, d1: Int): FString = hs(s, "-", rdec(d1))

  def rsubi(s: Int, d: Int): FString = h(d, rsubi(s))

  def rdec(d: Int): FString = rsubi(1, d)

  def ge1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", rdec(d), rclr(-1))

  def ge2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", rdec(d), rset(-1))

  def ge3(d: Int): FString = hm(-1, "-", ge2(d))

  def gt1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", rinc(d), rclr(-1))

  def gt2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", rinc(d), rset(-1))

  def gt3(d: Int): FString = hm(-1, "-", gt2(d))


  protected def add01(s: Int, d1: Int): FString = hs(s, "[-]", rinc(d1))

  protected def sub01(s: Int, d1: Int): FString = hs(s, "[-]", rdec(d1))

  protected def add2(s: Int, d1: Int, d2: Int): FString = hs(s, "-", rinc(d1), rinc(d2))

  protected def sub2(s: Int, d1: Int, d2: Int): FString = hs(s, "-", rdec(d1), rinc(d2))

  protected def addt(s: Int, d: Int, t: Int): FString = mkm(add2(s, d, t), raddc(t, s))

  protected def subt(s: Int, d: Int, t: Int): FString = mkm(sub2(s, d, t), raddc(t, s))


}
