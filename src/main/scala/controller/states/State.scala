package cl.uchile.dcc.citric
package controller.states

import cl.uchile.dcc.citric.controller.GameController

/** Trait which represents the actual state of a game
 *
 */
trait State {
  def setController(c: GameController): Unit

  var controller: GameController
}
