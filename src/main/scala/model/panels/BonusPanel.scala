package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** BonusPanel is a type of Panel which gives a certain bonus
 *
 * @param Characters the own list of player characters in the panel
 * @param NextPanels the own list of panels which are connected with the actual panel
 */
class BonusPanel(Characters: ArrayBuffer[PlayerCharacter],
                 NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  val characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels


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