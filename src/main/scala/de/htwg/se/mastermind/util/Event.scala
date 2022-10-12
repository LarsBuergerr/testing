/**
  * GameEvent.scala
  * Implements the STATE_PATTERN to keep track over current game state
  */

//********************************************************************** PACKAGE  
package de.htwg.se.mastermind
package util


trait Event

case class MenuState()        extends Event
case class PlayState()        extends Event
case class InitState()        extends Event

case class PlayerInputState() extends Event
case class PlayerWinState()   extends Event
case class PlayerLoseState()  extends Event

case class HelpState()        extends Event
case class EndState()         extends Event
case class QuitState()        extends Event