package cl.uchile.dcc.citric
package model.Panels

import model.Panel
import cl.uchile.dcc.citric.model.Units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @param Characters
 * @param NextPanels
 */
class bonusPanel(Characters: ArrayBuffer[PlayerCharacter],
                 NextPanels: ArrayBuffer[Panel]) extends absPanel {

  override var characters: ArrayBuffer[PlayerCharacter] = Characters
  override val nextPanels: ArrayBuffer[Panel] = NextPanels


  /** effect gives some stars to the Character
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    var c = roll * player.norma
    if (c > roll * 3) c = roll * 3
    player.setStars(c)

    addCharacter(player)
  }

}