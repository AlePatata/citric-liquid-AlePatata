package cl.uchile.dcc.citric
package model.units.wildunits

/** Kind of bellaco
 *
 */
class Chicken extends AWildUnit with WildUnit {
  protected var HP: Int = 3
  protected val maxHP: Int = HP
  protected var attack: Int = -1
  protected var defense: Int = -1
  protected var stars: Int = 0
  protected val evasion: Int = 1
  protected val bonus = 3 //the extra amount of stars to transfer in a combat


}