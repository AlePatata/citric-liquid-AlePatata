package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** AbsPanel has the implementations of the set of the common methods that a panel should had
 */
abstract class AbsPanel extends Panel {
  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  val characters: ArrayBuffer[PlayerCharacter]
  /** Array of the next panels with respect to this panel
   */
  val nextPanels: ArrayBuffer[Panel]

  /** Adds a panel to the list of nextPanels currently on this panel.
   *
   * This might be invoked when the controller begins the game.
   *
   * @param panel The new panel to add to this panel.
   */
  def addPanel(panel: Panel): Unit = {
    nextPanels += panel
  }

  /** Removes a panel of the list of nextPanels of this panel.
   *
   * This might be invoked when the controller begins the game.
   *
   * @param panel The panel to remove of this panel.
   */
  def removePanel(panel: Panel): Unit = {
    nextPanels -= panel
  }

  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }

  /** Removes a character from the list of characters currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }

  def setOwner(player: PlayerCharacter): Unit = {}

  /*def getNextPanels: ArrayBuffer[Panel] = {
    val aux = nextPanels
    aux
  }

  def setNextPanels(newNextPanels: ArrayBuffer[Panel]): Unit = {
    NextPanels
  }*/
}
