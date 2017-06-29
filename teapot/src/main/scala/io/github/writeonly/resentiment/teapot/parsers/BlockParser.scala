package io.github.writeonly.resentiment.teapot.parsers

import io.github.writeonly.resentiment.teapot.command.Command

import scala.util.parsing.combinator.{JavaTokenParsers, PackratParsers, Parsers}

trait BlockParser extends Parsers {
  def apply(text : String) : ParseResult[Command]
}

trait BlockParserLL extends BlockParser with JavaTokenParsers {}

trait BlockParserLR extends BlockParserLL with PackratParsers {}
