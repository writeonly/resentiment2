package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.UniCore

class InstructionsDsl(engine : UniCore[Unit]) {
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
  def mod(operand :Int) = {engine.umod(operand); this}


}
