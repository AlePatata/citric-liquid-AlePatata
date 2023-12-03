package cl.uchile.dcc.citric
package controller.states

import model.combat.Combat

class CombatState extends AState {
  val player = controller.getCurrentPlayer()
  val panel = controller.getCurrentPanel()
  def endCombat(): Unit = {
    val s: State = new LandingPanel
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
