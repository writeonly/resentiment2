package io.github.writeonly.resentment.corn.phrases.analyzers

import scala.util.parsing.combinator.PackratParsers

trait AnalyzerLR
  extends AnalyzerLL
    with PackratParsers
