package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.fsm.api.Memory
import io.github.writeonly.resentment.ipu.core.api.RedCore

import scala.util.{Failure, Success, Try}

class RedCoreFake extends Fake with RedCore[Unit] {

  override def rnop(): Unit = {}

  override def rclr(d: Int): Unit = memory(d) = 0

  override def rset(d: Int): Unit = memory(d) = 1

  override def rmovi(r: (Int, Int)): Unit =
    memory(r._2) = r._1.asInstanceOf[Byte]

  override def rmov(r: (Int, Int)): Unit = memory(r._2) = memory(r._1)

  override def rmovc(r: (Int, Int)): Unit = {
    memory(r._2) = memory(r._1)
    memory(r._1) = 0
  }

  override def rswap(d1: Int, d2: Int): Unit = {
    val (v1, v2) = (memory(d1), memory(d2))
    memory(d1) = v2
    memory(d2) = v1
  }

  override def radd(r: (Int, Int)): Unit = comi(r, _ + _)

  override def raddc(r: (Int, Int)): Unit = comic(r, _ + _)

  override def raddi(r: (Int, Int)): Unit = comii(r, _ + _)

  override def rsub(r: (Int, Int)): Unit = comi(r, _ - _)

  override def rsubc(r: (Int, Int)): Unit = comic(r, _ - _)

  override def rsubi(r: (Int, Int)): Unit = comii(r, _ - _)

  override def rmul(r: (Int, Int)): Unit = comi(r, _ * _)

  override def rmulc(r: (Int, Int)): Unit = comic(r, _ * _)

  override def rmuli(r: (Int, Int)): Unit = comii(r, _ * _)

  override def rdiv(r: (Int, Int)): Unit = comi(r, _ / _)

  override def rdivc(r: (Int, Int)): Unit = comic(r, _ / _)

  override def rdivi(r: (Int, Int)): Unit = comii(r, _ / _)

  override def rmod(r: (Int, Int)): Unit = comi(r, _ % _)

  override def rmodc(r: (Int, Int)): Unit = comic(r, _ % _)

  override def rmodi(r: (Int, Int)): Unit = comii(r, _ % _)

  override def rpow(r: (Int, Int)): Unit = comi(r, pow)

  def pow(x: Byte, y: Byte): Int = pow(x, y.asInstanceOf[Int])

  def pow(x: Byte, y: Int): Int = Try(BigInt(x).pow(y).intValue()) match {
    case Success(v) => v
    case Failure(e) =>
      throw new IllegalArgumentException("x -> " + x + ", y -> " + y, e)
  }

  override def rpowc(r: (Int, Int)): Unit = comic(r, pow)

  override def rpowi(r: (Int, Int)): Unit = comii(r, pow)

  override def rneg(d: Int): Unit = memory(d) = -memory(d)

  override def rng1(d: Int): Unit = memory(d) = -memory(d) + 1

  override def rnot(d: Int): Unit = memory(d) = !Memory.toBoolean(memory(d))

  override def rtau(d: Int): Unit = memory(d) = Memory.toBoolean(memory(d))

  override def req(r: (Int, Int)): Unit = comx(r, _ == _)

  override def reqc(r: (Int, Int)): Unit = comxc(r, _ == _)

  override def reqi(r: (Int, Int)): Unit = comxi(r, _ == _)

  override def rne(r: (Int, Int)): Unit = comx(r, _ != _)

  override def rnec(r: (Int, Int)): Unit = comxc(r, _ != _)

  override def rnei(r: (Int, Int)): Unit = comxi(r, _ != _)

  override def rle(r: (Int, Int)): Unit = comx(r, _ >= _)

  override def rlec(r: (Int, Int)): Unit = comxc(r, _ >= _)

  override def rlei(r: (Int, Int)): Unit = comxi(r, _ >= _)

  override def rlt(r: (Int, Int)): Unit = comx(r, _ > _)

  override def rltc(r: (Int, Int)): Unit = comxc(r, _ > _)

  override def rlti(r: (Int, Int)): Unit = comxi(r, _ > _)

  override def rand(r: (Int, Int)): Unit = comxx(r, _ && _)

  override def randc(r: (Int, Int)): Unit = comxxc(r, _ && _)

  override def randi(r: (Int, Int)): Unit = comxxi(r, _ && _)

  override def ror(r: (Int, Int)): Unit = comxx(r, _ || _)

  override def rorc(r: (Int, Int)): Unit = comxxc(r, _ || _)

  override def rori(r: (Int, Int)): Unit = comxxi(r, _ || _)
}
