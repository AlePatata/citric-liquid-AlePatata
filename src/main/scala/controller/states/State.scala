package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.controller.GameController

trait State {
  def setController(c: GameController): Unit

  var controller: GameController
}
