package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** This kind of panel doesn't do anything
 *
 */
class NeutralPanel(Characters: ArrayBuffer[PlayerCharacter],
                   NextPanels: ArrayBuffer[Panel]) extends AbsPanel{

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** apply just actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    addCharacter(player)
  }
}