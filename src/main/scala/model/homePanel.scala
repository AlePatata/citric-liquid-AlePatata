package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

class homePanel(Characters: ArrayBuffer[PlayerCharacter],
                NextPanels: ArrayBuffer[Panel], Id: Int) extends absPanel {

  val characters = Characters
  var nextPanels = NextPanels
  val: id = Id

  /** effect do the NormaCheck and actualizate the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit {
    player.HP++
    norma = new Norma
    norma.NormaCheck(player)
    addCharacter (player)
  }
}