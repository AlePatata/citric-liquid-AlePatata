package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** A class which represents a Drop Panel
 *
 * When a Player Character falls here he/she will lose a certain
 * amount of stars
 *
 * @param Characters For create
 * @param NextPanels
 */

class dropPanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends absPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** effect stills some stars to the Character
   * and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    player.setStars(roll * player.norma)
    addCharacter(player)
  }
}
