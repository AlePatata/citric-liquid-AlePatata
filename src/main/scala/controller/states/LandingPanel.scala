package cl.uchile.dcc.citric
package controller.states

import controller.GameController

class LandingPanel(c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel()
  /*def doEffect(): Unit = {
    val s: State = controller.getChapter()
    controller.changeState(s)
    s.controller = controller
    panel(player)

    println("New Round\n")
  }*/
}
