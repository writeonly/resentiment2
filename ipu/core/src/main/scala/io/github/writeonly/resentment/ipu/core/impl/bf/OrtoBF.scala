package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class OrtoBF extends MetaBF {

  lazy val add = new Orto1 {
    override def tmp(s:Int, d:Int, t:Int*):FString = mkm(add2(s, d, t(0)), cl(t(0), s))
    override def dir(s:Int, d:Int):FString = tmp(s, d, -1)
    override def cl(s:Int, d:Int):FString = hs(s, "-", rinc(d))
    override def im(s:Int, d:Int):FString = h(d, raddi(s))
  }

  lazy val sub = new Orto1 {
    override def tmp(s:Int, d:Int, t:Int*):FString = mkm(sub2(s, d, t(0)), add.cl(t(0), s))
    override def dir(s:Int, d:Int):FString = tmp(s, d, -1)
    override def cl(s:Int, d:Int):FString = hs(s, "-", rdec(d))
    override def im(s:Int, d:Int):FString = h(d, rsubi(s))
  }

  lazy val mov = new Orto1 {
    override def tmp(s: Int, d: Int, t: Int*): FString = mkm(rclr(d), add.tmp(s, d, t :_* ))
    override def dir(s: Int, d: Int): FString = mkm(rclr(d), add.dir(s, d))
    override def cl(s: Int, d: Int): FString = mkm(rclr(d), add.cl(s, d))
    override def im(s: Int, d: Int): FString = mkm(rclr(d), add.im(s, d))
  }

  def rclr(d: Int): FString = hs(d, "-")

  def rset(d: Int): FString = mov.one(d)

  def rinc(d: Int): FString = add.one(d)

  def rdec(d: Int): FString = sub.one(d)

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

  protected def addt(s: Int, d: Int, t: Int): FString = mkm(add2(s, d, t), add.cl(t, s))

  protected def subt(s: Int, d: Int, t: Int): FString = mkm(sub2(s, d, t), add.cl(t, s))

}
