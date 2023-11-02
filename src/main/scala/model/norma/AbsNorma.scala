package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter

/** AbsNorma represents the level of a player in the game
 *
 * Corresponds to a set of methods for increase the own norma
 * of a player, and determines when the game is over.
 *
 */
abstract class AbsNorma extends Norma {
  protected var level = 1

  def getLevel: Int = {
    val aux = level
    aux
  }
  def setLevel(Level: Int): Unit = {
    level = Level
  }
}