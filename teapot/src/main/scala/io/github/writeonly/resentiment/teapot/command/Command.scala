package io.github.writeonly.resentiment.teapot.command

abstract class Command
case class Word(bytes: Array[Byte]) extends Command

abstract class Operation extends Command

abstract class BlockOperation extends Operation

case class Store(operand:Command, symbol:Symbol) extends BlockOperation
case class LoadVariable(symbol:Symbol) extends BlockOperation
case class LoadChar(constant: Char) extends BlockOperation
case class LoadInteger(constant: BigInt) extends BlockOperation
case class LoadDecinal(constant:BigDecimal) extends BlockOperation



case class UnaryOperation(operator: String, left: Command) extends BlockOperation
case class BinaryOperation(operator: String, left: Command, right: Command) extends BlockOperation

case class JumpOperation(operator:String, label: Symbol) extends Operation



case class UnaryOperator(operator: String, left: Command) extends Command
case class BinaryOperator(operator: String, left: Command, right: Command) extends Command
case class JumpOperator(operation:String) extends Command
case class CallOperator(operation:String) extends Command
case class ReturnOperator(operation:String) extends Command




