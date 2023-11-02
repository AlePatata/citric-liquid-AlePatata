package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.norma.AbsNorma
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class HomePanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** apply do the NormaCheck and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    player.setHP(1)
    player.getNorma.NormaCheck(player)
    addCharacter(player)
  }
}