package cl.uchile.dcc.citric
package model.panels

import model.units.{Chicken, PlayerCharacter, WildUnit}
import cl.uchile.dcc.citric.model.combat.WildCombat

import scala.collection.mutable.ArrayBuffer

/** EncounterPanel is a type of Panel which begin a combat with an enemy
 *
 * @param Characters the own list of player characters in the panel
 * @param NextPanels the own list of panels which are connected with the actual panel
 */
class EncounterPanel(Characters: ArrayBuffer[PlayerCharacter],
                     NextPanels: ArrayBuffer[Panel],
                     wildunit: WildUnit = new Chicken) extends AbsPanel {

  val characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels
  private val wildUnit: WildUnit = wildunit

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