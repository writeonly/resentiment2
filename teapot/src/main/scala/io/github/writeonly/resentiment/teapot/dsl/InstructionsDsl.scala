package io.github.writeonly.resentiment.teapot.dsl

import io.github.writeonly.resentiment.teapot.core.Instructions

class InstructionsDsl(engine : Instructions) {
  def ld(operand :Symbol) = {engine.ld(operand); this}
  def ld(operand :Int) = {engine.ld(operand); this}
  def st(operand :Symbol) = {engine.st(operand); this}

  def add(operand :Symbol) = {engine.ld(operand); this}
  def add(operand :Int) = {engine.add(operand); this}
  def sub(operand :Symbol) = {engine.sub(operand); this}
  def sub(operand :Int) = {engine.sub(operand); this}

}
