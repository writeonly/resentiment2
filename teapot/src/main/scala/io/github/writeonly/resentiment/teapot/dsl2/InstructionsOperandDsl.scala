package io.github.writeonly.resentiment.teapot.dsl2

import io.github.writeonly.resentiment.teapot.engine2.Instructions

class InstructionsOperandDsl(engine : Instructions) {
  def ld(operand :Symbol) = {engine.uld(operand); this}
  def ld(operand :Int) = {engine.uld(operand); this}
  def st(operand :Symbol) = {engine.ust(operand); this}

  def add(operand :Symbol) = {engine.uadd(operand); this}
  def add(operand :Int) = {engine.uadd(operand); this}
  def sub(operand :Symbol) = {engine.usub(operand); this}
  def sub(operand :Int) = {engine.usub(operand); this}
  def neg() = {engine.pneg(); this}

  def mul(operand :Symbol) = {engine.umul(operand); this}
  def mul(operand :Int) = {engine.umul(operand); this}
  def div(operand :Symbol) = {engine.udiv(operand); this}
  def div(operand :Int) = {engine.udiv(operand); this}
  def mod(operand :Symbol) = {engine.umod(operand); this}
  def mod(operand :Int) = {engine.mod(operand); this}


}
