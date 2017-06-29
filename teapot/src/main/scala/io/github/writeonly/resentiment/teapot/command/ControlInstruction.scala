package io.github.writeonly.resentiment.teapot.command

class ControlInstruction {

}

class LabelInstruction(label : Symbol, operand : Symbol) extends ControlInstruction{

}

class jmp(label : Symbol, operand : Symbol) extends  {

}

class cal(label : Symbol, operand : Symbol) extends LabelInstruction(label, operand) {

}

class ret extends ControlInstruction {

}