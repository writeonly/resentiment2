package io.github.writeonly.resentiment.teapot.stack

class InstructionsDsl(engine : Instructions) {
  def ld(operand :Int) = {engine.ld(operand); this}
  def ld(operand :Symbol) = {engine.ld(operand); this}
  def st(operand :Symbol) = {engine.st(operand); this}
  def push = {engine.push; this}

  def add = {engine.add; this}
  def sub = {engine.sub; this}
  def neg = {engine.neg; this}

  def mul = {engine.mul; this}
  def div = {engine.div; this}
  def mod = {engine.mod; this}


}
