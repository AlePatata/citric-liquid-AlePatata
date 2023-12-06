package cl.uchile.dcc.citric
package controller.states

import controller.GameController
/** Class in charge of applies the effect of the current panel on the current player */
class LandingPanel(c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel(player)

  doEffect()
  /** Calls to the panel's apply function and end the turn of the player */
  def doEffect(): Unit = {
    panel.apply(player)

    println("New Round\n")
  }
}
