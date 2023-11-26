package cl.uchile.dcc.citric
package model.controller

import model.units.PlayerCharacter

class PlayerTurn(val character: PlayerCharacter) extends AState {

  def rollDice(): Unit = {
    val roll = character.rollDice()
    val s: State = new Moving(roll)
    controller.changeState(s)
    s.controller = controller

    println("End Game\n")
  }
}
