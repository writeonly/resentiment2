package io.github.writeonly.resentment.corn.compilator.generators

import io.github.writeonly.resentment.corn.notation.Command
import io.github.writeonly.resentment.fsm.StreamIO

trait Generator {
  def apply(code : Command) : Unit
}
