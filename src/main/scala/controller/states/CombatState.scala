package cl.uchile.dcc.citric
package controller.states

import model.combat.Combat

import cl.uchile.dcc.citric.controller.GameController

class CombatState(c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  val panel = controller.getCurrentPanel(player)

  if (panel.characters.nonEmpty) startCombat()
  else endCombat()

  def endCombat(): Unit = {
    controller.changeState(new LandingPanel(c: GameController))

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
