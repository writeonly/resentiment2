package io.github.writeonly.resentiment.teapot.dsl

import io.github.writeonly.resentiment.teapot.core.Instructions

class InstructionsDsl(engine : Instructions) {
  def ld(operand :Symbol) = {engine.ld(operand); this}
  def ld(operand :Int) = {engine.ld(operand); this}
  def st(operand :Symbol) = {engine.st(operand); this}

  def add(operand :Symbol) = {engine.add(operand); this}
  def add(operand :Int) = {engine.add(operand); this}
  def sub(operand :Symbol) = {engine.sub(operand); this}
  def sub(operand :Int) = {engine.sub(operand); this}
  def neg() = {engine.neg(); this}

  def mul(operand :Symbol) = {engine.mul(operand); this}
  def mul(operand :Int) = {engine.mul(operand); this}
  def div(operand :Symbol) = {engine.div(operand); this}
  def div(operand :Int) = {engine.div(operand); this}
  def mod(operand :Symbol) = {engine.mod(operand); this}
  def mod(operand :Int) = {engine.mod(operand); this}


}
