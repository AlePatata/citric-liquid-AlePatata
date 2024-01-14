package cl.uchile.dcc.citric
package controller

import cl.uchile.dcc.citric.controller.states.{ChapterState, EndGame, PreGame, State}
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

/** GameController is the class in charge of the correct functioning of the game flow
 *
 */
class GameController {
  /** Actual state of the game */
  private var state: State = _
  private val characters = ArrayBuffer[PlayerCharacter]()
  /** Observers of the controller */
  private val observers = ArrayBuffer[Observer]()
  /** turns is a map in which it is ordered "key: value" like turn number and its corresponding player. */
  var turns = Map[Int, PlayerCharacter]()
  var tablero = new Tablero
  /** variable which saves the chapter number */
  private var chapter = 1
  val maxChapter = 5
  /** Is the player in turn */
  private var currentPlayer: Option[PlayerCharacter] = None
  /** Is a map which saves the actual position of every player */
  private val currentPanels = Map[PlayerCharacter, Option[Panel]]()


  var finish = true
  /** Starts the initial configurations for the game
   *
   */
  def startGame(): Unit = {
    changeState(new PreGame(this))
    finish = false
  }
  /** Starts the rounds
   */
  def startRounds(): Unit = {
    while (!finish) {
      changeState(new ChapterState(chapter, this))
      chapter += 1
    }
    chapter -= 1
  }
  /** Change the state of the controller */
  def changeState(s: State): Unit = {
    state = s
  }

  /** Finalize the cicle of the game */
  def endGame(): Unit = {
    changeState(new EndGame(this))
    finish = true
  }
  /** Returns the player in turn
   * @throws AssertionError if there are not a player in turn
   */
  def getCurrentPlayer(): PlayerCharacter = {
    if (currentPlayer.isDefined) {
      currentPlayer.get
    } else {
      throw new AssertionError("There is no current player defined")
    }
  }
  /** Setter for the actual player in turn */
  def setCurrentPlayer(player: PlayerCharacter): Unit = {
    currentPlayer = Some(player)
  }
  /** Getter of the "player: panel" map */
  def getCurrentPanels(): Map[PlayerCharacter,Option[Panel]] = {
    currentPanels
  }
  /** Getter of the actual panel of a specific player
   * @throws AssertionError if there is not a panel defined fo that player */
  def getCurrentPanel(player: PlayerCharacter): Panel = {
    val currentPanel: Option[Panel] = currentPanels(player)
    if (currentPanel.isDefined) {
      currentPanel.get
    } else {
      throw new AssertionError("There is no current panel defined")
    }
  }
  /** Setter of the panel of the actual player in turn */
  def setCurrentPanel(panel: Panel): Unit = {
    val panelDeJugador = currentPanels(currentPlayer.get)
    if (panelDeJugador.isEmpty) { // If there isn't a current panel for the player
      currentPlayer.get.home = Some(panel)
      currentPanels(currentPlayer.get) = Some(panel)
    } else currentPanels(currentPlayer.get) = Some(panel)
  }
  /** Getter of the chapter */
  def getChapter(): Int = {
    val c = chapter
    c
  }
  /** Adds a player in the array of players for the game */
  def addPlayer(player: PlayerCharacter) = {
    characters += player
  }
  /** Adds an observer in the array of observer */
  def addObserver(o: Observer): Unit = {
    observers += o
    for (o <- observers) o.setController(this)
  }
  /** Getter of the players in the game */
  def getPlayers(): ArrayBuffer[PlayerCharacter] = {
    val c = characters
    c
  }
}
