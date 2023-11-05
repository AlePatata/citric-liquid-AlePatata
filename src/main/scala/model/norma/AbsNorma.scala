package cl.uchile.dcc.citric
package model.norma


/** AbsNorma represents the level of a player in the game
 *
 * Corresponds to a set of methods for increase the own norma
 * of a player, and determines when the game is over.
 *
 * @author [[https://github.com/AlePatata/ Alejandra Campos Urbina]]
 */
abstract class AbsNorma extends Norma {
  /** The norma level respect to a player
   *
   * This variable keeps track of the player's norma, and for its delicate value in the game it's protected
   */
  protected var level = 1

  /** Getter of level
   *
   * @return A copy of the level value
   */
  def getLevel: Int = {
    val aux = level
    aux
  }

  /** Setter of level
   *
   * @param Level the new level to change
   */
  def setLevel(Level: Int): Unit = {
    level = Level
  }
}