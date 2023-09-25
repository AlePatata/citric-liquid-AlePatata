
package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** This kind of panel doesn't do anything
 *
 */
class neutralPanel(Characters: ArrayBuffer[PlayerCharacter],
                   NextPanels: ArrayBuffer[Panel], Id: Int) extends absPanel{

  val characters = Characters
  var nextPanels = NextPanels
  val id = Id

  /** effect just actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter){
    addCharacter(player)
  }
}