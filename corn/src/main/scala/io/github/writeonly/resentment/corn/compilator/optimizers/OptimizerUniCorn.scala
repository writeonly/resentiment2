package io.github.writeonly.resentment.corn.compilator.optimizers

import io.github.writeonly.resentment.corn.notation.Command

class OptimizerUniCorn extends Optimizer {
  override def apply(tree: Command): Command = tree
}
