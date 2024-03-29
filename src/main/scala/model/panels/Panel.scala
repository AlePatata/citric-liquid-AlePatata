package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own apply, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an apply (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/AlePatata/ Alejandra Campos Urbina]]
  */
trait Panel {
  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  val characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  val nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  def removeCharacter(player: PlayerCharacter): Unit

  /** Adds a panel to the list of nextPanels currently on this panel.
   *
   * This might be invoked when the controller begins the game.
   *
   * @param panel The new panel to add to this panel.
   */
  def addPanel(panel: Panel): Unit

  /** Removes a panel of the list of nextPanels of this panel.
   *
   * This might be invoked when the controller begins the game.
   *
   * @param panel The panel to remove of this panel.
   */
  def removePanel(panel: Panel): Unit

  /** For each type of panel the function will affect the player in a different way.
   *
   * @param player The player character to affect.
   */
  def apply(player: PlayerCharacter): Unit


}
