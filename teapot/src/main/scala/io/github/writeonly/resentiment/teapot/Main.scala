package io.github.writeonly.resentiment.teapot

import io.github.writeonly.resentiment.teapot.compilers.Calculator

object Main extends App {
  val calc = new Calculator

  println(calc.evaluate("10+10")) // prosty example
  println(calc.evaluate("2+2*2")) // haczyk z podstawówki mnożenie jest najpierw
  println(calc.evaluate("(2+2)*2")) // wymuśmy działanie
  println(calc.evaluate("2^3^4")) // raczej oczywisty wynik
  println(calc.evaluate("2^-3^4")) // też chyba spodziewany, potęga jest łączna prawostronnie
  println(calc.evaluate("(2^-3)^4")) // a tu wymuszenie 2^-3 == (1/2)^3 stąd ułamek
  println(calc.evaluate("-7+6*2/3+9^2-1")) // -7+6*2/3+81-1 <=> -7+12/3+81-1 <=> -7+4+81-1 <=> 77 // coś "skomplikowanego"
  println(calc.parse("-7+5*3/3+9^2-1")) // obejrzyjmy sobie drzewko (niestety bez wcięć)
}