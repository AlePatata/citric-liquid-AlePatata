package cl.uchile.dcc.citric
package controller.states

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.controller.GameController

class PlayerTurn(val character: PlayerCharacter,c: GameController) extends AState(c: GameController) {
  controller.setCurrentPlayer(character)
  println(s"${character.name} throws the dice\n")
  rollDice()
  def rollDice(): Unit = {
    val roll = character.rollDice()
    println(s"It's a $roll!\n")
    val s: State = new Moving(roll,controller)
    controller.changeState(s)
    s.controller = controller
  }
}
