package cl.uchile.dcc.citric
package controller.states

import model.combat.Combat

import cl.uchile.dcc.citric.controller.GameController

class CombatState(c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  val panel = controller.getCurrentPanel()
  def endCombat(): Unit = {
    val s: State = new LandingPanel(c: GameController)
    controller.changeState(s)
    s.controller = controller

    println("Landing Panel\n")
  }
  def startCombat(): Unit = {
    if (panel.characters.nonEmpty) {
      new Combat(player,panel.characters(0))
    } else {
      endCombat()
    }
  }
}
