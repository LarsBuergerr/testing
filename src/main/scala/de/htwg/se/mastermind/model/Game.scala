/**
  * Game.scala
  */

//********************************************************************** PACKAGE  
package de.htwg.se.mastermind
package model


//********************************************************************** IMPORTS
import util._


//******************************************************************** CLASS DEF
/**
  * Represents a game instance with it's current state and game field
  *
  * @param field  mastermind game field
  * @param state  state in which the game is currently
  */
case class Game(var field: Field, var state: State = Init()){
  
  private var currentTurn: Int = 0
  
  private val maxTurn: Int = field.matrix.rows
  
  //Partial function gets string and returns a event
  type PartialFunctionRule = PartialFunction[String, Event]
  
  // Defines the Chain of Responsibility (Pattern)
  val chainSCR: PartialFunctionRule = {
    RequestHandlerSCR.HelpInputRule orElse 
    RequestHandlerSCR.MenuInputRule orElse
    RequestHandlerSCR.PlayInputRule orElse
    RequestHandlerSCR.QuitInputRule
  }
  
  /**
    * Calls the responsible chain
    *
    * @param request
    * @return
    */
  def handleRequest(request: Request): Event = {
    request match {
      case SingleCharRequest(userinput) => {
        //println("SingleCharRequest: " + userinput)                              //@todo remove after debugging
        chainSCR.applyOrElse(userinput, RequestHandlerSCR.DefaultInputRule)
      }
      case MultiCharRequest(userinput) => {
        //println("MultiCharRequest: " + userinput)                               //@todo remove after debugging
        println("Oh no, this shouldn't happen!")
        QuitStateEvent()
      }
    }
  }

  /**
    * Handles the current state of the game (State Pattern)
    *
    * @param event  event to be handled
    * @return       new state of the game
    */
  def request(event: Event): State = {
    //println("<<<debug>>>: handler called")                                    //@todo remove after debugging
    event match{
      case init: InitState        => state = Init()
      case menu: MenuStateEvent   => state = Menu()
      case play: PlayState        => state = Play()
      case quit: QuitStateEvent   => state = Quit()
      case help: HelpStateEvent   => state = Help()
      
      case pInp: PlayerInputState => state = PlayerInput()
      case pLos: PlayerLoseState  => state = PlayerLose()
      case pWin: PlayerWinState   => state = PlayerWin() 
    }
    return state.handle()
  }
  
  override def toString(): String = field.toString
  
  def getMaxTurns() = maxTurn
  def getRemainingTurns() = maxTurn - currentTurn
  def getCurrentTurn() = currentTurn
  def setTurn(): Int = {
    currentTurn = currentTurn + 1
    return currentTurn
  }
  
  def getCurrentStateEvent(): Event = {
    state match {
      case init:Init        => HelpStateEvent()
      case menu:Menu        => MenuStateEvent()
      case play:Play        => PlayState()
      case quit:Quit        => QuitStateEvent()
      case help:Help        => HelpStateEvent()
    }
  }
  
  object RequestHandlerSCR {
    
    //defines the general rule for the chain
    def singleCharRule(f: String => Boolean, result: Event): PartialFunctionRule = {
      case s if f(s) => result
    }
    
    //defines the concrete rules
    val HelpInputRule: PartialFunctionRule = singleCharRule(_ == "h", HelpStateEvent())
    val MenuInputRule: PartialFunctionRule = singleCharRule(_ == "m", MenuStateEvent())
    val PlayInputRule: PartialFunctionRule = singleCharRule(_ == "p", PlayState())
    val QuitInputRule: PartialFunctionRule = singleCharRule(_ == "q", QuitStateEvent())
    
    //defines the default rule
    def DefaultInputRule(userinput: String): Event = {
      println(">>> Error: Invalid input [will be ignored]")
      getCurrentStateEvent()
    }
  }
  
  object RequestHandlerMCR {
    
    //defines the general rule for the chain
    def multiCharRule(f: String => Boolean, result: Event): PartialFunctionRule = {
      case s if f(s) => result
    }
    
    //defines the concrete rules
    //val HelpInputRule: PartialFunctionRule = multiCharRule(_.size.equals(), HelpStateEvent())
    
    //defines the default rule
    def DefaultInputRule(userinput: String): Event = {
      println(">>> Error: Invalid input [will be ignored]")
      getCurrentStateEvent()
    }
  }
}