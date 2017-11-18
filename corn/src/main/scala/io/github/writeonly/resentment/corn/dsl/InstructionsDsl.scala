package io.github.writeonly.resentment.corn.dsl

import io.github.writeonly.resentment.core.api.UniCore

class InstructionsDsl(engine : UniCore[Unit]) /*extends UniCore[InstructionsDsl] */{
  def uld(operand :Symbol) = {engine.uld(operand); this}
  def uld(operand :Int) = {engine.uld(operand); this}
  def ust(operand :Symbol) = {engine.ust(operand); this}

  def uadd(operand :Symbol) = {engine.uadd(operand); this}
  def uadd(operand :Int) = {engine.uadd(operand); this}
  def usub(operand :Symbol) = {engine.usub(operand); this}
  def usub(operand :Int) = {engine.usub(operand); this}
  def uneg() = {engine.pneg(); this}

  def umul(operand :Symbol) = {engine.umul(operand); this}
  def umul(operand :Int) = {engine.umul(operand); this}
  def udiv(operand :Symbol) = {engine.udiv(operand); this}
  def udiv(operand :Int) = {engine.udiv(operand); this}
  def umod(operand :Symbol) = {engine.umod(operand); this}
  def umod(operand :Int) = {engine.umod(operand); this}


}
