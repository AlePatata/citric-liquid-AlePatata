package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

abstract class absPanel extends Panel {

  val characters: ArrayBuffer[PlayerCharacter]
  var nextPanels: ArrayBuffer[Panel]

  def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }
  def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }

  /** For each type of panel the function will affect the player in a different way.
   *
   * @param player The player character to affect.
   */
  def effect(player: PlayerCharacter): Unit
}