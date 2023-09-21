
package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** This kind of panel doesn't do anything
 *
 */
class neutralPanel extends absPanel(Characters: ArrayBuffer[PlayerCharacter],
  NextPanels: ArrayBuffer[Panel]){

  val characters = Characters
  var nextPanels = NextPanels

  /** effect just actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter){
    addCharacter(player)
  }
}