package io.github.writeonly.resentment.corn.phrases.generators

import io.github.writeonly.resentment.core.pipe.StreamIO
import io.github.writeonly.resentment.corn.command.Command

trait Generator {
  def apply(code : Command) : Unit
}
