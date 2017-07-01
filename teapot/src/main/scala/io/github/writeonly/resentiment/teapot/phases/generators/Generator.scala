package io.github.writeonly.resentiment.teapot.phases.generators

import io.github.writeonly.resentiment.teapot.core.Command

trait Generator {
  def apply(code : Command) : String
}
