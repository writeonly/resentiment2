package io.github.writeonly.resentment.ipu.corn.compilator.optimizers

import io.github.writeonly.resentment.ipu.corn.notation.Command

class OptimizerPopCorn extends Optimizer {
  override def apply(tree: Command): Command = tree
}
