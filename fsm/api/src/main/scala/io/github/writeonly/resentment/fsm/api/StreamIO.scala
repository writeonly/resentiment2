package io.github.writeonly.resentment.fsm.api

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, InputStream, OutputStream}

case class StreamIO(in: InputStream, out: OutputStream) {
  def apply(f: StreamIO => Unit): StreamIO = {
    f(this)
    this
  }

  override def toString: String = out.asInstanceOf[ByteArrayOutputStream].toString
}

object StreamIO {
  def byteArray(in: Array[Byte]): StreamIO = StreamIO(new ByteArrayInputStream(in), new ByteArrayOutputStream())

  def byteArray(in: String): StreamIO = byteArray(in.getBytes)

  def byteArray(): StreamIO = byteArray("")
}
