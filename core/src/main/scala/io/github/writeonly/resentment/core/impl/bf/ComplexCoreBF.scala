package io.github.writeonly.resentment.core.impl.bf

import java.io.PrintStream

class ComplexCoreBF(print:PrintStream) extends CoreBF(print) {

  def cclr(d:Int) :FString = rw(d, "-")

  def cconst(s:Int, d:Int) :FString = rw(d, "-", "+", s)

  def cmv(s: Int, d: Int) : FString = mk(cclr(d), add2(s, d, -1), add1(-1, s))

  def cadd(s: Int, d: Int) : FString = mk(add2(s, d, -1), add1(-1, s))

  def csub(s: Int, d: Int) : FString = mk(sub2(s, d, -1), add1(-1, s))

  def cmul(s: Int, d: Int) : FString = mk(add1(d, -2), rw(-2, "-", add2(s,d,-1), add1(-1, s)))


}
