package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer


class encounterPanel(Characters: ArrayBuffer[PlayerCharacter],
                     NextPanels: ArrayBuffer[Panel],
                     Id: Int,
                     wildUnit: WildUnit) extends absPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels
  val id: Int = Id

  /** effect put the player and a wild unit in a combat
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    val c = new Combat
    c.combat(player, wildUnit)
    addCharacter(player)
  }
}