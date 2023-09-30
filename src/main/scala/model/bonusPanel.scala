package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @param Characters
 * @param NextPanels
 */
class bonusPanel(Characters: ArrayBuffer[PlayerCharacter],
                 NextPanels: ArrayBuffer[Panel], Id: Int) extends absPanel {

  override var characters: ArrayBuffer[PlayerCharacter] = Characters
  override val nextPanels: ArrayBuffer[Panel] = NextPanels
  /** Unique number for each panel which identifies it
   *
   * In case of have multiplies types of the same panel (e.g. 2 neutral panels
   * without players characters on them and with the same list of next panels)
   * this integer will distinguish it from another with similar features
   */
  override val id: Int = Id

  /** effect gives some stars to the Character
   * and actualize the position of the player
   *
   * @param player The Player Character affected
   */
  def effect(player: PlayerCharacter): Unit = {
    val roll = player.rollDice()
    var c = roll * player.norma
    if (c > roll * 3) c = roll * 3
    player.setStars(c)

    addCharacter(player)
  }

}