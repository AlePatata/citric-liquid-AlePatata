package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.controller.GameController
/** Abstract class of a game state */
abstract class AState(c: GameController) extends State {
  var controller: GameController = c
  /** Setter of the controller */
  def setController(c: GameController) = {
    controller = c
  }
}
