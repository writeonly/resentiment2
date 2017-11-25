package io.github.writeonly.resentment.corn.compilator.analyzers

import scala.util.parsing.combinator.JavaTokenParsers

trait AnalyzerLL
  extends Analyzer
    with JavaTokenParsers
