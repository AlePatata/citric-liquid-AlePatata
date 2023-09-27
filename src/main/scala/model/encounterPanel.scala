package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer


class encounterPanel(Characters: ArrayBuffer[PlayerCharacter],
                     NextPanels: ArrayBuffer[Panel],
                     Id: Int,
                     wildUnit: WildUnit) extends absPanel {

  val characters = Characters
  var nextPanels = NextPanels
  val id = Id

  /** effect put the player and a wild unit in a combat
   * and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    c = new Combat
    c.combat(player, wildUnit)
    addCharacter(player)
  }
}