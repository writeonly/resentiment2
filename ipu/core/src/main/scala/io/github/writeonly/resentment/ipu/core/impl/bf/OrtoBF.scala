package io.github.writeonly.resentment.ipu.core.impl.bf

import io.github.writeonly.resentment.ipu.core.common.FString

class OrtoBF extends MetaBF {

  trait OrtoCl extends Orto {
    override def tmp(r: (Int, Int), t: Int*): FString = dir(r)

    override def cl(r: (Int, Int)): FString = mkm(dir(r), rclr(r._1))
  }

  lazy val add = new Orto1 {
    override def tmp(r: (Int, Int), t: Int*): FString =
      mkm(add2(r, t(0)), cl(t(0), r._1))

    override def dir(r: (Int, Int)): FString = tmp(r, -1)

    override def cl(r: (Int, Int)): FString = hs(r._1, dec, rinc(r._2))

    override def im(r: (Int, Int)): FString = h(r._2, raddi(r._1))
  }

  lazy val sub = new Orto1 {
    override def tmp(r: (Int, Int), t: Int*): FString =
      mkm(sub2(r, t(0)), add.cl(t(0), r._1))

    override def dir(r: (Int, Int)): FString = tmp(r, -1)

    override def cl(r: (Int, Int)): FString = hs(r._1, dec, rdec(r._2))

    override def im(r: (Int, Int)): FString = h(r._2, rsubi(r._1))
  }

  lazy val mov = new Orto1 {
    override def tmp(r: (Int, Int), t: Int*): FString =
      mkm(rclr(r._2), add.tmp(r, t: _*))

    override def dir(r: (Int, Int)): FString = mkm(rclr(r._2), add.dir(r))

    override def cl(r: (Int, Int)): FString = mkm(rclr(r._2), add.cl(r))

    override def im(r: (Int, Int)): FString = mkm(rclr(r._2), add.im(r))
  }

  lazy val mul = new OrtoCl {
    override def dir(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -2), hs(-2, dec, add.dir(r)))

    override def im(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -1), hs(-1, dec, add.im(r)))
  }

  //  temp0[-]
  //  temp1[-]
  //  temp2[-]
  //  temp3[-]
  //  x[temp0+x-]
  //  temp0[
  //    y[temp1+temp2+y-]
  //    temp2[y+temp2-]
  //    temp1[
  //      temp2+
  //      temp0-
  //      [temp2[-]temp3+temp0-]
  //      temp3[temp0+temp3-]
  //      temp2[
  //        temp1-
  //        [x-temp1[-]]+
  //      temp2-]
  //    temp1-]
  //    x+
  //  temp0]
  lazy val div = new OrtoCl {
    override def dir(r: (Int, Int)): FString = mkm(
      add.cl(r._2, -1),
      hs(
        -1,
        add.tmp((r._1, -2), -3),
        hs(-2,
           dec,
           rinc(-3),
           rdec(-1),
           hs(-1, dec, rclr(-3), rinc(-4)),
           hs(-4, dec, rinc(-1)),
           hs(-3, dec, rdec(-2), hm(-2, clr, rdec(r._2)), rinc(-2))),
        h(r._2, inc)
      )
    )

    override def im(r: (Int, Int)): FString = mkm(
      add.cl(r._2, -1),
      hs(
        -1,
        add.im(r._1, -2),
        hs(-2,
           dec,
           rinc(-3),
           rdec(-1),
           hs(-1, dec, rclr(-3), rinc(-4)),
           hs(-4, dec, rinc(-1)),
           hs(-3, dec, rdec(-2), hm(-2, clr, rdec(r._2)), rinc(-2))),
        h(r._2, inc)
      )
    )
  }

//[->-[>+>>]>[+[-<+>]>+>>]<<<<<]
  lazy val divmod = new OrtoTmp {
    private def divmod1(d: Int) = h(d, "[-<-[<+<<]<[+[->+<]<+<<]>>>>>]")

    private def divmod2(d: Int) =
      mkm(add.cl(d, -1), divmod1(d), add.cl(-4, d), rcls(-3, -2, -1))

    override def dir(r: (Int, Int)): FString =
      mkm(add.dir(r._1, -2), divmod2(r._2))

    override def cl(r: (Int, Int)): FString =
      mkm(add.cl(r._1, -2), divmod2(r._2))

    override def im(r: (Int, Int)): FString =
      mkm(add.im(r._1, -2), divmod2(r._2))
  }

  //[>->+<[>]>[<+>-]<<[<]>-]
  lazy val mod = new OrtoTmp {
    private def mod1(d: Int): FString = h(d, "[<-<+>[<]<[>+<-]>>[>]<-]")

    private def mod2(d: Int): FString =
      mkm(mov.cl(d, -3), mod1(-2), add.cl(-4, d), rclr(-3))

    override def dir(r: (Int, Int)): FString =
      mkm(add.dir(r._1, -2), mod2(r._2))

    override def cl(r: (Int, Int)): FString = mkm(add.cl(r._1, -2), mod2(r._2))

    override def im(r: (Int, Int)): FString = mkm(add.im(r._1, -2), mod2(r._2))
  }

  //  temp0[-]
  //  x[temp0+x-]
  //  x+
  //  y[
  //    temp1[-]
  //    temp2[-]
  //    x[temp2+x-]
  //    temp2[
  //      temp0[x+temp1+temp0-]
  //      temp1[temp0+temp1-]
  //    temp2-]
  //  y-]
  lazy val pow = new OrtoCl {
    override def dir(r: (Int, Int)): FString =
      mkm(mov.dir(r._1, -4), cl(r), add.cl(-4, r._1))

    override def cl(r: (Int, Int)): FString = mkm(
      add.cl(r._2, -1),
      rinc(r._2),
      hs(r._1,
         dec,
         rclr(-2),
         rclr(-3),
         add.cl(r._2, -3),
         hs(-3, dec, add.tmp((-1, r._2), -2)))
    )

    override def im(r: (Int, Int)): FString =
      mkm(add.im(r._1, -4), cl(-4, r._2))
  }

  lazy val leq = new OrtoTmp {
    override def dir(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -2),
          rinc(r._2),
          sub.tmp((r._1, -2), -1),
          sub01(-2, r._2))

    override def cl(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -2), rinc(r._2), sub.cl(r._1, -2), sub01(-2, r._2))

    override def im(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -1), sub.im(r._1, -1), sub01(-1, r._2))
  }

  lazy val lne = new OrtoTmp {
    override def dir(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -2), sub.tmp((r._1, -2), -1), add01(-2, r._2))

    override def cl(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -2), sub.cl(r._1, -2), add01(-2, r._2))

    override def im(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -1), sub.im(r._1, -1), add01(-1, r._2))
  }

  lazy val lle = new OrtoTmp {

    def ge1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", rdec(d), rclr(-1))

    def ge2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", rdec(d), rset(-1))

    def ge3(d: Int): FString = hm(-1, dec, ge2(d))

    override def dir(r: (Int, Int)): FString =
      mkm(rinc(-3),
          add.tmp((r._1, -2), -1),
          add.cl(r._2, -1),
          rinc(r._2),
          ge1(r._2),
          ge3(r._2))

    override def cl(r: (Int, Int)): FString =
      mkm(rinc(-3),
          add.cl(r._1, -2),
          add.cl(r._2, -1),
          rinc(r._2),
          ge1(r._2),
          ge3(r._2))

    override def im(r: (Int, Int)): FString =
      mkm(rinc(-3),
          add.tmp((r._1, -2), -1),
          add.cl(r._2, -1),
          rinc(r._2),
          ge1(r._2),
          ge3(r._2))
  }

  lazy val llt = new OrtoTmp {

    def gt1(d: Int): FString = rm(-2, "[<-]<[>", "<-<]>+>", rinc(d), rclr(-1))

    def gt2(d: Int): FString = rm(-2, "-[<-]<[>", "<-<]>+>", rinc(d), rset(-1))

    def gt3(d: Int): FString = hm(-1, dec, gt2(d))

    override def dir(r: (Int, Int)): FString =
      mkm(rinc(-3),
          add.tmp((r._1, -1), -2),
          add.cl(r._2, -2),
          gt1(r._2),
          gt3(r._2))

    override def cl(r: (Int, Int)): FString =
      mkm(rinc(-3), add.cl(r._1, -1), add.cl(r._2, -2), gt1(r._2), gt3(r._2))

    override def im(r: (Int, Int)): FString =
      mkm(rinc(-3),
          add.tmp((r._1, -1), -2),
          add.cl(r._2, -2),
          gt1(r._2),
          gt3(r._2))
  }

//  temp0[-]
//  temp1[-]
//  z[-]
//  x[
//    temp0+
//    y[- temp0[-] temp1+ y]
//    temp0[- z+ temp0]
//    temp1[- y+ temp1]
//  y- x- ]

  //  temp0[-]
  //  temp1[-]
  //  x[temp1+x-]
  //  temp1[
  //    temp1[-]
  //    y[temp1+temp0+y-]
  //    temp0[y+temp0-]
  //    temp1[x+temp1[-]]
  //  ]
  lazy val land = new OrtoTmp {
    override def dir(r: (Int, Int)): FString =
      mkm(add.cl(r._2, -2),
          hs(-2, rclr(-2), add.dir(r._1, -2), add01(-2, r._2)))

    override def cl(r: (Int, Int)): FString = mkm(dir(r), rclr(r._1))

    override def im(r: (Int, Int)): FString =
      mkm(add.im(r._1, -3), dir(-3, r._2), rclr(-3))
  }

  //  temp0[-]
  //  temp1[-]
  //  x[temp1+x-]
  //  temp1[x-temp1[-]]
  //  y[temp1+temp0+y-]
  //  temp0[y+temp0-]
  //  temp1[x[-]-temp1[-]]
  lazy val lor = new OrtoTmp {
    private def tau(d: Int): FString = mkm(add.cl(d, -2), add01(-2, d))

    private def lor1(d: Int): FString = hs(-2, clr, mov.im(1, d))

    override def dir(r: (Int, Int)): FString =
      mkm(tau(r._2), add.dir(r._1, -2), lor1(r._2))

    override def cl(r: (Int, Int)): FString =
      mkm(tau(r._2), add.cl(r._1, -2), lor1(r._2))

    override def im(r: (Int, Int)): FString =
      mkm(tau(r._2), add.im(r._1, -2), lor1(r._2))
  }

  def rcls(s: Int*): FString = mkm((for (d <- s) yield rclr(d)): _*)

  def rclr(d: Int): FString = h(d, clr)

  def rset(d: Int): FString = mov.one(d)

  def rinc(d: Int): FString = add.one(d)

  def rdec(d: Int): FString = sub.one(d)

  def add01(r: (Int, Int)): FString = hs(r._1, clr, rinc(r._2))

  def sub01(r: (Int, Int)): FString = hs(r._1, clr, rdec(r._2))

  protected def add2(r: (Int, Int), d2: Int): FString =
    hs(r._1, dec, rinc(r._2), rinc(d2))

  protected def sub2(r: (Int, Int), d2: Int): FString =
    hs(r._1, dec, rdec(r._2), rinc(d2))

}
