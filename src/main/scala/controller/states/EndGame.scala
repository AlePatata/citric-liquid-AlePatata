package cl.uchile.dcc.citric
package controller.states

import controller.GameController
/** Class which represents the finish game state */
class EndGame(c: GameController) extends AState(c: GameController) {
  // just print a line and end the cycle
  println("Game Over\n")
}
