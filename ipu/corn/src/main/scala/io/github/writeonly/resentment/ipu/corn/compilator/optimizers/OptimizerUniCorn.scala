package io.github.writeonly.resentment.ipu.corn.compilator.optimizers

import io.github.writeonly.resentment.ipu.corn.notation.Command

class OptimizerUniCorn extends Optimizer {
  override def apply(tree: Command): Command = tree
}
