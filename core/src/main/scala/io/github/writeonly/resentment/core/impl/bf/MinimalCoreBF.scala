package io.github.writeonly.resentment.core.impl.bf

import java.io.PrintStream

import io.github.writeonly.resentment.core.api.PopCore

class MinimalCoreBF(print : PrintStream) extends CoreBF(print) with PopCore[Unit] {

  def pop(code : String) = print.append(v(code)).append("<")

  val add = v("[<+>-]")

  val neg = v("[>-<-]") + v(">"+add+"<")

  override def uvar(o: Symbol) = ???

  override def ust(o: Symbol) = ???

  override def ppop() = ???

  override def ppush() = ???

  override def padd() = pop(add)

  override def psub() = pop("[<->-]")

  override def pmul() = pop(v("<[>>>+<<<-]>")+v(">>[< "+v("<[<+>>+<-]>")+v(add)+">-]<<"))

  override def pdiv() = ???

  override def pmod() = ???

  override def peq() = pop(v("["))

  override def pne() = ???

  override def plt() = ???

  override def ple() = ???

  override def pgt() = ???

  override def pge() = ???

  override def pand() = ???

  override def por() = ???

  override def pnot() = ???

  override def pneg() = append(neg)

  override def png1() = append(v("-") + neg)

  override def uld(o: Symbol) = ???

  override def uld(o: Int) = ???

  override def uld(o: Char) = ???

  override def uld(o: String) = ???

  override def pin() = ???

  override def pout() = ???
}
