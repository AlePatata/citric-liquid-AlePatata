package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** A class which represents a Drop Panel
 *
 * When a Player Character falls here he/she will lose a certain
 * amount of stars
 *
 * @param Characters the own list of player characters in the panel
 * @param NextPanels the own list of panels which are connected with the actual panel
 */

class DropPanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  val characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** apply stills some stars to the Character
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    player.setStars(roll * player.getNorma.getLevel)
    addCharacter(player)
  }
}
