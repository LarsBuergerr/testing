/**
  * FILENAME.scala
  */

//********************************************************************** PACKAGE  
package de.htwg.se.mastermind
package model

//********************************************************************** IMPORTS
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._


class StoneSpec extends AnyWordSpec{
  "A Stone object" should {
    "be only instanced one time (singleton pattern)" in {
      Stone should be(Stone)
    }
    "have a function to generate random stones that are not Empty" in {
      for(i <- 1 to 1000){
        Stone.random should not be(Stone("E"))
      }
    }
  }
  "A Game-Stone" should {
    "have a String representation of its color [Initial letter]" in {
      Stone.apply("R").toString() should be("R")
      Stone.apply("G").toString() should be("G")
      Stone.apply("B").toString() should be("B")
      Stone.apply("Y").toString() should be("Y")
      Stone.apply("P").toString() should be("P")
      Stone.apply("W").toString() should be("W")
      Stone.apply(" ").toString() should be("E")
      Stone.apply("E").toString() should be("E")
    }
  }
  "A Hint-Stone" should {
    "have a String representation of its color [Initial letter]" in {
      HintStone.apply("R").toString() should be("R")
      HintStone.apply("W").toString() should be("W")
      HintStone.apply("E").toString() should be("E")
      HintStone.apply(" ").toString() should be("E")
    }  
  }
}