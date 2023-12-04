package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map
import scala.util.Random

class PreGame(c: GameController) extends AState(c: GameController) {
  println("Welcome to 99.7 Citric Liquid!\n")
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
  if(players.nonEmpty) ObserversConfig()
  def ObserversConfig(): Unit = {
    for (p <- players) {
      for (o <- p.observers) {
        o.setController(controller)
        controller.addObserver(o)
      }
    }
  }
}
