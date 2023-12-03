package cl.uchile.dcc.citric
package controller.states

import model.units.PlayerCharacter

class PlayerTurn(val character: PlayerCharacter) extends AState {
  controller.setCurrentPlayer(character)
  println(s"${character.name} throws the dice\n")
  rollDice()
  def rollDice(): Unit = {
    val roll = character.rollDice()
    println(s"It's a $roll!\n")
    val s: State = new Moving(roll)
    controller.changeState(s)
    s.controller = controller
  }
}
