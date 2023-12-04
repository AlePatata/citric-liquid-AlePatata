package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.controller.GameController

abstract class AState(c: GameController) extends State {
  var controller: GameController = c

  def setController(c: GameController) = {
    controller = c
  }
}
