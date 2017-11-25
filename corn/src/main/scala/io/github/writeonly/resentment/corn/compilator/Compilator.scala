package io.github.writeonly.resentment.corn.compilator

import io.github.writeonly.resentment.corn.compilator.analyzers.Analyzer
import io.github.writeonly.resentment.corn.compilator.generators.Generator
import io.github.writeonly.resentment.corn.compilator.optimizers.Optimizer

class Compilator(val frondEnd:Analyzer, val backEnd:Generator, val middleEnd: Optimizer = new Optimizer()) {

  def apply(code:String):Unit = backEnd(middleEnd(frondEnd(code)))

}
