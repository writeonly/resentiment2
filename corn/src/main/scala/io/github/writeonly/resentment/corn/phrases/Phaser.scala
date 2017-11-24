package io.github.writeonly.resentment.corn.phrases

import io.github.writeonly.resentment.corn.phrases.analyzers.Analyzer
import io.github.writeonly.resentment.corn.phrases.generators.Generator
import io.github.writeonly.resentment.corn.phrases.optimizers.Optimizer

class Phaser(val frondEnd:Analyzer, val backEnd:Generator, val middleEnd: Optimizer = new Optimizer()) {

  def apply(code:String):Unit = backEnd(middleEnd(frondEnd(code)))

}
