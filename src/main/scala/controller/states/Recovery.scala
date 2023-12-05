package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.model.units.PlayerCharacter

class Recovery(player: PlayerCharacter, c: GameController) extends AState(c: GameController) {
  val needed = 6 - controller.getChapter()
  val roll = player.rollDice()
  Recover(roll)
  def Recover(Roll: Int): Unit = {
    if (Roll >= needed) {
      player.setHP(player.maxHP)
      controller.changeState(new PlayerTurn(player,controller))

      println(s"${player.name} has been recovered\n")
    }
  }

}
