package io.github.writeonly.resentment.core.impl.bf

import java.io.PrintStream

class CoreBF(print : PrintStream) {
  type FString = () => String

  var head = 0

  def append(code : String) = print.append(v(code))


  def v(code:String) = {
    require(count(code, '[') ==  count(code, ']') && count(code, '<') ==  count(code, '>'))
    code
  }

  def count(code:String, c : Char) = code.count(_ == c)

  def r(i:Int, s:String, n:Int) : FString = () => {
    val shift = i - head
    head = i
    if (0 <= shift) ">" * shift + s else "<" * (-shift) + s * n
  }

  def r(i:Int, s:String) : FString = r(i, s, 1)

  def r(i:Int) : FString = r(i, "")

  def rw(w:Int, in:String, out:String, n:Int, seq : FString*):FString = () => join(r(w)(),"[", mk(seq:_*)(),r(w, in)(),"]", out * n)

  def rw(w:Int, in:String, out:String, seq : FString*):FString = rw(w, in, out, 1, seq:_*)

  def rw(w:Int, in:String, seq : FString*):FString = rw(w, in, "", seq :_*)

  def mk(others : FString*):FString = () =>  others.map(f => f()).mkString("")

  def join(s:String*) = s.mkString("")

  def add1(s:Int, d1 :Int) : FString = rw(s, "-", r(d1, "+"))

  def add(s: Int = 0, d : Int = 1) = rw(s, "-", r(d, "+"))

  def sub(s: Int = 0, d : Int = 1) = rw(s, "-", r(d, "-"))
  def add2(s:Int, d1 :Int, d2:Int) : FString = rw(s, "-", r(d1, "+"), r(d2, "+"))

}
