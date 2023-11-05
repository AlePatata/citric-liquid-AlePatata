package cl.uchile.dcc.citric
package model.units

/** A Wild Unit is a kind of unit the represents an enemy in the game
 *
 */
trait WildUnit extends Units {
  protected val bonus: Int
  protected val maxHP: Int
  def respawn(): Unit
}