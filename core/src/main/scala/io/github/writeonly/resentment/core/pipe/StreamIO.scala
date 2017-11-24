package io.github.writeonly.resentment.core.pipe

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, InputStream, OutputStream}

case class StreamIO(in: InputStream, out: OutputStream)

object StreamIO {
  def byteArray(in: Array[Byte]) : StreamIO = StreamIO(new ByteArrayInputStream(in), new ByteArrayOutputStream())
  def byteArray(in: String) : StreamIO = byteArray(in.getBytes)
  def byteArray(io:StreamIO) :String = io.out.asInstanceOf[ByteArrayOutputStream].toString
}
