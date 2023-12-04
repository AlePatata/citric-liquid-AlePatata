package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.norma.AbsNorma
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
/** HomePanel is a type of Panel that could actualize the level of a player
 *
 * @param Characters the own list of player characters in the panel
 * @param NextPanels the own list of panels which are connected with the actual panel
 */
class HomePanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel]) extends AbsPanel {

  val characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels
  var owner: PlayerCharacter = _

  /** apply do the NormaCheck and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def apply(player: PlayerCharacter): Unit = {
    player.setHP(1)
    player.getNorma.NormaCheck(player)
    addCharacter(player)
  }
  override def setOwner(player: PlayerCharacter): Unit = {
    owner = player
  }
}