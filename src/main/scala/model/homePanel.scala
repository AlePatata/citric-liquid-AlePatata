package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

class homePanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends absPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** effect do the NormaCheck and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    player.setHP(1)
    val norma = new Norma
    norma.NormaCheck(player, player.objective)
    addCharacter (player)
  }
}