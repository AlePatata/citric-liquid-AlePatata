package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer


class encounterPanel(Characters: ArrayBuffer[PlayerCharacter],
                     NextPanels: ArrayBuffer[Panel],
                     wildUnit: WildUnit) extends absPanel {

  val characters = Characters
  var nextPanels = NextPanels

  /** effect put the player and a wild unit in a combat
   * and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    combat(player, wildUnit)

    addCharacter(player)
  }
}