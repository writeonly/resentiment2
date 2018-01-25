package io.github.writeonly.resentment.ipu.core.api

trait Meta[T] {
  def mov: T
  def add: T
  def sub: T
  def mul: T
  def div: T
  def mod: T
  def leq: T
  def lne: T
  def lle: T
  def llt: T
  def land: T
  def lor: T
}
