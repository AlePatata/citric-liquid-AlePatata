package cl.uchile.dcc.citric
package controller.states

import controller.GameController

class Moving(var roll: Int,c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel()
  def StopMovement(): Unit = {
    roll = 0
  }
  private def outOfMovements(): Unit = {
    val s: State = new CombatState(controller)
    controller.changeState(s)
    s.controller = controller

    println("Starting a Combat\n")
  }

  def choosePath(): Unit = {
    roll -= 1
    controller.setCurrentPanel(panel.nextPanels(0))
  }

  if(roll == 0) outOfMovements()
}
