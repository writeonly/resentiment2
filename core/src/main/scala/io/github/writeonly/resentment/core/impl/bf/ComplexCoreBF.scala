package io.github.writeonly.resentment.core.impl.bf

import java.io.PrintStream

class ComplexCoreBF(print:PrintStream) extends CoreBF(print) {


  def cclr(d:Int) :FString = rw(d, "-")

  def cconst(s:Int, d:Int) :FString = rw(d, "-", "+", s)

  def cmv(s: Int, d: Int) : FString = mk(cclr(d), add2(s, d, -1), add1(-1, s))

}
