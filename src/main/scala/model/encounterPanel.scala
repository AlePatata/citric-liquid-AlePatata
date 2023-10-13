package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.Panels.absPanel
import cl.uchile.dcc.citric.model.Units.{PlayerCharacter, WildUnit}

import scala.collection.mutable.ArrayBuffer


class encounterPanel(Characters: ArrayBuffer[PlayerCharacter],
                     NextPanels: ArrayBuffer[Panel],
                     wildUnit: WildUnit) extends absPanel {

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels

  /** effect put the player and a wild unit in a combat
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    new WildCombat(player: PlayerCharacter, wildUnit)

    addCharacter(player)
  }
}