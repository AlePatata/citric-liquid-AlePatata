package cl.uchile.dcc.citric
package controller.states

import model.combat.Combat

import cl.uchile.dcc.citric.controller.GameController

/** Represents the state in which the player start a combat to fight with another player
 *
 * @param c controller
 */
class CombatState(c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  val panel = controller.getCurrentPanel(player)

  /** For default if there is someone else in the current panel the player will fight */
  if (panel.characters.nonEmpty) startCombat()
  else endCombat()
  /** Method to get out of the combat state and pass to the landing state */
  def endCombat(): Unit = {
    controller.changeState(new LandingPanel(c: GameController))

    println("Landing Panel\n")
  }
  /** Starts a Combat between the player in turn with the first player in the list of the panel */
  def startCombat(): Unit = {
    if (panel.characters.nonEmpty) {
      new Combat(player,panel.characters(0))
    } else {
      endCombat()
    }
  }
}
