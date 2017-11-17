package io.github.writeonly.resentment.core.impl

import java.math.BigInteger

import io.github.writeonly.resentment.core.api.UniCore

import scala.collection.mutable

class UniCoreFake extends UniCore {
  private val m : mutable.Map[Symbol, Int] = new mutable.HashMap[Symbol, Int]()

  private var a = 0

  private def get(operand: Symbol):Int = m.get(operand).getOrElse(0)


  private def toInt(o : Boolean) = if (o) 1 else 0
  private def toBoolean(o: Int) = o != 0
  private def set(o : Boolean) = a = toInt(o)



  override def ust(o: Symbol): Unit = m(o) = a

  override def uld(o: Symbol): Unit = a = get(o)

  override def uld(c: Int): Unit = a = c

  override def uld(c: BigInt): Unit = a = c.intValue()

  override def uld(c: String): Unit = uld(new BigInt(new BigInteger(c)))

  override def uadd(o: Symbol): Unit = uadd(get(o))
  override def uadd(o: Int): Unit = a += o
  override def usub(o: Symbol): Unit = usub(get(o))
  override def usub(o: Int): Unit = a -= o
  override def umul(o: Symbol): Unit = umul(get(o))
  override def umul(o: Int): Unit = a *= o
  override def udiv(o: Symbol): Unit = udiv(get(o))
  override def udiv(o: Int): Unit = a /= o
  override def umod(o: Symbol): Unit = umod(get(o))
  override def umod(o: Int): Unit = a %= o

  override def ueq(o: Symbol): Unit = ???
  override def ueq(o: Int): Unit = ???
  override def une(o: Symbol): Unit = ???
  override def une(o: Int): Unit = ???
  
  override def uand(o: Symbol): Unit = ???
  override def uand(o: Int): Unit = set(toBoolean(a) & toBoolean(o))
  override def uor(o: Symbol): Unit = ???
  override def uor(o: Int): Unit = ???

  override def ult(o: Symbol): Unit = ???
  override def ult(o: Int): Unit = ???
  override def ugt(o: Symbol): Unit = ???
  override def ugt(o: Int): Unit = ???

  override def ule(o: Symbol): Unit = ???
  override def ule(o: Int): Unit = ???
  override def uge(o: Symbol): Unit = ???
  override def uge(o: Int): Unit = ???
}
