package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @param Characters
 * @param NextPanels
 */
class BonusPanel(Characters: ArrayBuffer[PlayerCharacter],
                 NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  override var characters: ArrayBuffer[PlayerCharacter] = Characters
  override val nextPanels: ArrayBuffer[Panel] = NextPanels


  /** apply gives some stars to the Character
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    var level = roll * player.getNorma.getLevel
    if (level > roll * 3) level = roll * 3
    player.setStars(level)

    addCharacter(player)
  }

}