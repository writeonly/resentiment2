package io.github.writeonly.resentment.corn.compilator.analyzers

import scala.util.parsing.combinator.PackratParsers

trait AnalyzerLR
  extends AnalyzerLL
    with PackratParsers
