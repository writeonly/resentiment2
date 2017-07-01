package io.github.writeonly.resentiment.teapot.phases.analyzers

import io.github.writeonly.resentiment.teapot.command.Command

import scala.util.parsing.combinator.{JavaTokenParsers, PackratParsers, Parsers}

trait Analyzer extends Parsers {
  def parse(code : String) : ParseResult[Command]
  def apply(code : String) : Command = parse(code) match {
    case Success(r, n) => r
//    case NoSuccess(msg, n) => throw new IllegalArgumentException(msg + "|" + n)
    case f:Failure => throw new IllegalArgumentException(f.toString())
    case e:Error => throw new IllegalArgumentException(e.toString())
  }
}

trait AnalyzerLL extends Analyzer with JavaTokenParsers {}

trait AnalyzerLR extends AnalyzerLL with PackratParsers {}
