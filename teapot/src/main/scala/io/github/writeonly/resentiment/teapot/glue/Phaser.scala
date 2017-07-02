package io.github.writeonly.resentiment.teapot.glue

import io.github.writeonly.resentiment.teapot.phases.analyzers.Analyzer
import io.github.writeonly.resentiment.teapot.phases.generators.Generator
import io.github.writeonly.resentiment.teapot.phases.optimizers.Optimizer

class Phaser(val frondEnd:Analyzer, val backEnd:Generator, val middleEnd: Optimizer = new Optimizer()) {

  def apply(code:String):String = backEnd(middleEnd(frondEnd(code)))

}
