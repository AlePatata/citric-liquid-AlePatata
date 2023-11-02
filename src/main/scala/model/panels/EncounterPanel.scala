package cl.uchile.dcc.citric
package model.panels

import model.units.{Chicken, PlayerCharacter, WildUnit}
import model.WildCombat

import scala.collection.mutable.ArrayBuffer


class EncounterPanel(Characters: ArrayBuffer[PlayerCharacter],
                     NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels
  private val wildUnit: WildUnit = new Chicken



  /** apply put the player and a wild unit in a combat
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    new WildCombat(player: PlayerCharacter, wildUnit)

    addCharacter(player)
  }
}