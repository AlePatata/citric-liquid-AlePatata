package cl.uchile.dcc.citric
package model.units
/** Kind of bellaco
 *
 */
class Seagull extends AWildUnit with WildUnit {
  protected var HP = 3
  protected val maxHP: Int = HP
  protected var attack = 1
  protected var defense: Int = -1
  protected var stars = 0
  protected val evasion: Int = -1
  protected val bonus = 2 //the extra amount of stars to transfer in a combat

}
