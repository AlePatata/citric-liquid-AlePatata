package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.model.units.PlayerCharacter

/** Recovery is a type of state when the player in turn is KO
 *
 * @param player player character that is KO
 * @param c controller
 */
class Recovery(player: PlayerCharacter, c: GameController) extends AState(c: GameController) {
  /** amount of number needed in the dice for get out of the state */
  val needed = 6 - controller.getChapter()
  val roll = player.rollDice()
  Recover(roll)
  /** Method which asks if the number of the dice is enough
   *
   * if the number is enough then the player recovers all of their HP and goes to the actual Play Turn state
   */
  def Recover(Roll: Int): Unit = {
    if (Roll >= needed) {
      player.setHP(player.maxHP)
      controller.changeState(new PlayerTurn(player,controller))

      println(s"${player.name} has been recovered\n")
    }
  }

}
