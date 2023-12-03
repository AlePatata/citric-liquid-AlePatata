package cl.uchile.dcc.citric
package controller

import cl.uchile.dcc.citric.controller.states.{ChapterState, EndGame, PreGame, State}
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class GameController {
  private var state: State = _
  private var characters: ArrayBuffer[PlayerCharacter] = _
  private val observer: Observer = new Observer
  observer.controller = this

  private val chapter: Option[ChapterState] = None
  private var currentPlayer: Option[PlayerCharacter] = None
  private var currentPanel: Option[Panel] = None

  val s: State = new PreGame
  changeState(s)
  s.controller = this


  def changeState(s: State): Unit = {
    state = s
  }

  def endGame(): Unit = {
    changeState(new EndGame)
    println("End Game\n")
  }
  def getCurrentPlayer(): PlayerCharacter = {
    if (currentPlayer.isDefined) {
      currentPlayer.get
    } else {
      throw new AssertionError("There is no current player defined")
    }
  }
  def setCurrentPlayer(player: PlayerCharacter): Unit = {
    currentPlayer = Some(player)
  }
  def getCurrentPanel(): Panel = {
    if (currentPanel.isDefined) {
      currentPanel.get
    } else {
      throw new AssertionError("There is no current panel defined")
    }
  }
  def setCurrentPanel(panel: Panel): Unit = {
    currentPanel = Some(panel)
  }
  def getChapter(): ChapterState = {
    if (chapter.isDefined) {
      chapter.get
    } else {
      throw new AssertionError("There is no current chapter defined")
    }
  }


}
