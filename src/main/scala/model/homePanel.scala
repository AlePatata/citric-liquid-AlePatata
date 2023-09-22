package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

class homePanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends absPanel {

  val characters = Characters
  var nextPanels = NextPanels

  /** effect do the NormaCheck and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit {
    val roll = player.rollDice()

    addCharacter (player)
  }
}