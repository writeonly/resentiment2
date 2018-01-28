package io.github.writeonly.resentment.fsm.api

import java.io.{
  ByteArrayInputStream,
  ByteArrayOutputStream,
  InputStream,
  OutputStream
}

case class StreamIO(in: InputStream, out: OutputStream) {
  def apply(f: StreamIO => Unit): StreamIO = {
    f(this)
    this
  }

  override def toString: String =
    out.asInstanceOf[ByteArrayOutputStream].toString
}

object StreamIO {
  import io.github.writeonly.resentment.fsm.api.PipeOps.toPipe
  def byteArray(): StreamIO = byteArray("")

  def byteArray(in: String): StreamIO = in.getBytes |> byteArray

  def byteArray(in: Array[Byte]): StreamIO =
    StreamIO(new ByteArrayInputStream(in), new ByteArrayOutputStream())
}
