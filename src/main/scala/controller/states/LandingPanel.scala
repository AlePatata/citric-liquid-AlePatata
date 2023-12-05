package cl.uchile.dcc.citric
package controller.states

import controller.GameController

class LandingPanel(c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel(player)

  doEffect()

  def doEffect(): Unit = {
    panel.apply(player)

    println("New Round\n")
  }
}
