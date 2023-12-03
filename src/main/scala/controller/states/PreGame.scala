package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PreGame extends AState {
  //override def isStart(): Boolean = true
  def Turns(players: ArrayBuffer[PlayerCharacter]): ArrayBuffer[PlayerCharacter] = {
    /*var order = new Random(4)

    for (player <- players) {
      order


    }
    */
    players
  }

  def startGame(): Unit = {
    var s: State = new ChapterState(1)
    controller.changeState(s)
  }

  startGame()
}
