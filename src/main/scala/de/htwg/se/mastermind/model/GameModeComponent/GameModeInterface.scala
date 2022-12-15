/**
  * GameModeInterface.scala
  */

//****************************************************************************** PACKAGE  
package de.htwg.se.mastermind
package model
package GameModeComponent

//****************************************************************************** IMPORTS
import model.GameComponent.GameBaseImpl.{Field, Stone, HintStone}
import scala.io.StdIn.readLine


//****************************************************************************** INTERFACE
trait GameModeInterface {
  
  var selectMode : Field
  
  def strategy_easy: Field
  
  def strategy_medium: Field
  
  def strategy_hard: Field
  
  def strategy_extrem: Field
  
  def parseInput(): Field
}