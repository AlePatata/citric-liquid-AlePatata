package cl.uchile.dcc.citric
package controller

import cl.uchile.dcc.citric.controller.states.{ChapterState, EndGame, PreGame, State}
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

class GameController {
  private var state: State = _
  private val characters = ArrayBuffer[PlayerCharacter]()
  private val observers = ArrayBuffer[Observer]()
  var turns = Map[Int, PlayerCharacter]()
  var tablero = new Tablero

  private var chapter = 1
  val maxChapter = 5
  private var currentPlayer: Option[PlayerCharacter] = None
  private var currentPanels = Map[PlayerCharacter, Option[Panel]]()


  var finish = true

  def startGame(): Unit = {
    changeState(new PreGame(this))
    finish = false
  }

  def startRounds(): Unit = {
    while (!finish) {
      changeState(new ChapterState(chapter, this))
      chapter += 1
    }
    chapter -= 1
  }
  def changeState(s: State): Unit = {
    state = s
  }

  def endGame(): Unit = {
    changeState(new EndGame(this))
    println("Game Over\n")
    finish = true
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
  def getCurrentPanels(): Map[PlayerCharacter,Option[Panel]] = {
    currentPanels
  }
  def getCurrentPanel(player: PlayerCharacter): Panel = {
    val currentPanel: Option[Panel] = currentPanels(player)
    if (currentPanel.isDefined) {
      currentPanel.get
    } else {
      throw new AssertionError("There is no current panel defined")
    }
  }
  def setCurrentPanel(panel: Panel): Unit = {
    val panelDeJugador = currentPanels(currentPlayer.get)
    if (panelDeJugador.isEmpty) { // If there isn't a current panel for the player
      currentPlayer.get.home = Some(panel)
      currentPanels(currentPlayer.get) = Some(panel)
    } else currentPanels(currentPlayer.get) = Some(panel)
  }
  def getChapter(): Int = {
    val c = chapter
    c
  }
  def addPlayer(player: PlayerCharacter) = {
    characters += player
  }

  def addObserver(o: Observer): Unit = {
    observers += o
    for (o <- observers) o.setController(this)
  }
  def getPlayers(): ArrayBuffer[PlayerCharacter] = {
    val c = characters
    c
  }

}
