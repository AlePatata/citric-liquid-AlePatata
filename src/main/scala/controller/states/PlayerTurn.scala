package cl.uchile.dcc.citric
package controller.states

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.controller.GameController
/** State in charge of throws the player's dice to move in the board
 */
class PlayerTurn(val character: PlayerCharacter, c: GameController) extends AState(c: GameController) {
  controller.setCurrentPlayer(character)
  println(s"${character.name} throws the dice:\n")
  rollDice()
  /** After throws the dice changes the controller game state to Moving */
  def rollDice(): Unit = {
    val roll = character.rollDice()
    println(s"It's a $roll!\n")
    controller.changeState(new Moving(roll,controller))
  }
}
