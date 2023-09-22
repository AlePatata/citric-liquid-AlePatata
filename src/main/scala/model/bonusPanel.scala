package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @param Characters
 * @param NextPanels
 */
class bonusPanel(Characters: ArrayBuffer[PlayerCharacter],
                 NextPanels: ArrayBuffer[Panel]) extends absPanel {

  val characters = Characters
  var nextPanels = NextPanels

  /** effect gives some stars to the Character
   * and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    c = roll * player.norma
    if (c > roll * 3) c = roll * 3
    player.stars += c

    addCharacter(player)
  }
}