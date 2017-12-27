package io.github.writeonly.resentment.ipu.corn.compilator

import io.github.writeonly.resentment.ipu.corn.compilator.analyzers.Analyzer
import io.github.writeonly.resentment.ipu.corn.compilator.generators.Generator
import io.github.writeonly.resentment.ipu.corn.compilator.optimizers.Optimizer

class Compilator(val frondEnd: Analyzer, val backEnd: Generator, val middleEnd: Optimizer = new Optimizer()) {

  def apply(code: String): Unit = backEnd(middleEnd(frondEnd(code)))

}
