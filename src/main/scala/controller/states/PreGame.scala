package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map
import scala.util.Random

/** PreGame is the class in charge of all the previous configurations before to star the game
 *
 * @param c controller
 */
class PreGame(c: GameController) extends AState(c: GameController) {
  println("Welcome to 99.7 Citric Liquid!\n")
  /** Sorted the turns and pass them to the variable turns in controller
   * @see GameController */
  def Turns(players: ArrayBuffer[PlayerCharacter]): Map[Int,PlayerCharacter] = {
    val order = new Random(13)
    var n = order.nextInt(players.length+1)
    val map = Map[Int,PlayerCharacter]()
    for (player <- players) {
      map += (n%players.length -> player)
      n += 1
    }
    map
  }

  val players = controller.getPlayers()
  controller.turns = Turns(players)
  // if there are players in the list we configure some of theirs variables
  if(players.nonEmpty) {
    ObserversConfig()
    CurrentPanelsConfig()
  }
  /** Relations the subject to observe (the players) with the controller */
  def ObserversConfig(): Unit = {
    for (p <- players) {
      for (o <- p.observers) {
        o.setController(controller)
        controller.addObserver(o)
      }
    }
  }
  /** Assigns the necessary keys for save the locations (panels) of each player */
  def CurrentPanelsConfig(): Unit = {
    val panels = controller.getCurrentPanels()
    for (p <- players) {
      panels += (p -> None)
    }
  }
}
