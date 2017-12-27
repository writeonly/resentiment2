package io.github.writeonly.resentment.ipu.corn.compilator.generators

import io.github.writeonly.resentment.ipu.corn.notation.Command

trait Generator {
  def apply(code: Command): Unit
}
