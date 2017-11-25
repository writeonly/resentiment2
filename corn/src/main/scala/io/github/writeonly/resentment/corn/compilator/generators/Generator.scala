package io.github.writeonly.resentment.corn.compilator.generators

import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.notation.Command

trait Generator {
  def apply(code : Command) : Unit
}
