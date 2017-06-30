package io.github.writeonly.resentiment.teapot.glue

import io.github.writeonly.resentiment.teapot.phases.analyzers.Analyzer
import io.github.writeonly.resentiment.teapot.phases.generators.Generator
import io.github.writeonly.resentiment.teapot.phases.optimizers.Optimizer

class Phaser(frondEnd:Analyzer, backEnd:Generator, middleEnd: Optimizer = new Optimizer()) {
  def apply(code:String):String = backEnd(middleEnd(frondEnd(code)))

}
