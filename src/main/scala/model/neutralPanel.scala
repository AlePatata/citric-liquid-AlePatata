package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** This kind of panel doesn't do anything
 *
 */
class neutralPanel(Characters: ArrayBuffer[PlayerCharacter],
                   NextPanels: ArrayBuffer[Panel], Id: Int) extends absPanel{

  var characters: ArrayBuffer[PlayerCharacter] = Characters
  val nextPanels: ArrayBuffer[Panel] = NextPanels
  val id: Int = Id

  /** effect just actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    addCharacter(player)
  }
}