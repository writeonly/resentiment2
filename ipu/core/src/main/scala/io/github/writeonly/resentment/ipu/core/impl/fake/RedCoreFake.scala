package io.github.writeonly.resentment.ipu.core.impl.fake

import io.github.writeonly.resentment.fsm.api.Memory
import io.github.writeonly.resentment.ipu.core.api.RedCore

import scala.util.{Failure, Success, Try}

class RedCoreFake extends Fake with RedCore[Unit] {

  override def rnop(): Unit = {}

  override def rclr(d: Int): Unit = memory(d) = 0

  override def rset(d: Int): Unit = memory(d) = 1

  override def rmovi(s: Int, d: Int): Unit = memory(d) = s.asInstanceOf[Byte]

  override def rmov(s: Int, d: Int): Unit = memory(d) = memory(s)

  override def rmovc(s: Int, d: Int): Unit = {
    memory(d) = memory(s)
    memory(s) = 0
  }

  override def rswap(d1: Int, d2: Int): Unit = {
    val (v1, v2) = (memory(d1), memory(d2))
    memory(d1) = v2
    memory(d2) = v1
  }

  override def radd(s: Int, d: Int): Unit = comi(s, d, _ + _)

  override def raddc(s: Int, d: Int): Unit = comic(s, d, _ + _)

  override def raddi(s: Int, d: Int): Unit = comii(s, d, _ + _)

  override def rsub(s: Int, d: Int): Unit = comi(s, d, _ - _)

  override def rsubc(s: Int, d: Int): Unit = comic(s, d, _ - _)

  override def rsubi(s: Int, d: Int): Unit = comii(s, d, _ - _)

  override def rmul(s: Int, d: Int): Unit = comi(s, d, _ * _)

  override def rmulc(s: Int, d: Int): Unit = comic(s, d, _ * _)

  override def rmuli(s: Int, d: Int): Unit = comii(s, d, _ * _)

  override def rdiv(s: Int, d: Int): Unit = comi(s, d, _ / _)

  override def rdivc(s: Int, d: Int): Unit = comic(s, d, _ / _)

  override def rdivi(s: Int, d: Int): Unit = comii(s, d, _ / _)

  override def rmod(s: Int, d: Int): Unit = comi(s, d, _ % _)

  override def rmodc(s: Int, d: Int): Unit = comic(s, d, _ % _)

  override def rmodi(s: Int, d: Int): Unit = comii(s, d, _ % _)

  override def rpow(s: Int, d: Int): Unit = comi(s, d, pow)

  def pow(x: Byte, y: Byte): Int = pow(x, y.asInstanceOf[Int])

  def pow(x: Byte, y: Int): Int = Try(BigInt(x).pow(y).intValue()) match {
    case Success(v) => v
    case Failure(e) =>
      throw new IllegalArgumentException("x -> " + x + ", y -> " + y, e)
  }

  override def rpowc(s: Int, d: Int): Unit = comic(s, d, pow)

  override def rpowi(s: Int, d: Int): Unit = comii(s, d, pow)

  override def rneg(d: Int): Unit = memory(d) = -memory(d)

  override def rng1(d: Int): Unit = memory(d) = -memory(d) + 1

  override def rnot(d: Int): Unit = memory(d) = !Memory.toBoolean(memory(d))

  override def rtau(d: Int): Unit = memory(d) = Memory.toBoolean(memory(d))

  override def req(s: Int, d: Int): Unit = comx(s, d, _ == _)

  override def reqc(s: Int, d: Int): Unit = comxc(s, d, _ == _)

  override def reqi(s: Int, d: Int): Unit = comxi(s, d, _ == _)

  override def rne(s: Int, d: Int): Unit = comx(s, d, _ != _)

  override def rnec(s: Int, d: Int): Unit = comxc(s, d, _ != _)

  override def rnei(s: Int, d: Int): Unit = comxi(s, d, _ != _)

  override def rle(s: Int, d: Int): Unit = comx(s, d, _ >= _)

  override def rlec(s: Int, d: Int): Unit = comxc(s, d, _ >= _)

  override def rlei(s: Int, d: Int): Unit = comxi(s, d, _ >= _)

  override def rlt(s: Int, d: Int): Unit = comx(s, d, _ > _)

  override def rltc(s: Int, d: Int): Unit = comxc(s, d, _ > _)

  override def rlti(s: Int, d: Int): Unit = comxi(s, d, _ > _)

  override def rand(s: Int, d: Int): Unit = comxx(s, d, _ && _)

  override def randc(s: Int, d: Int): Unit = comxxc(s, d, _ && _)

  override def randi(s: Int, d: Int): Unit = comxxi(s, d, _ && _)

  override def ror(s: Int, d: Int): Unit = comxx(s, d, _ || _)

  override def rorc(s: Int, d: Int): Unit = comxxc(s, d, _ || _)

  override def rori(s: Int, d: Int): Unit = comxxi(s, d, _ || _)
}
