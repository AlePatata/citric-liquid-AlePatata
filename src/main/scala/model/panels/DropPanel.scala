package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** A class which represents a Drop Panel
 *
 * When a Player Character falls here he/she will lose a certain
 * amount of stars
 *
 * @param Characters For create
 * @param NextPanels
 */

class DropPanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** apply stills some stars to the Character
   * and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    player.setStars(roll * player.norma)
    addCharacter(player)
  }
}
