package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/** AUnits has the implementations of a set of the common methods that a unit should had
 */
abstract class AUnits extends Units {
  protected var HP: Int
  protected var attack: Int
  protected var defense: Int
  protected val evasion: Int
  protected var stars: Int
  /** Getter of HP */
  def getHP: Int = {
    val aux = HP
    aux
  }
  /** Setter of HP */
  def setHP(increase: Int): Unit = {
    HP += increase
    if(HP < 0) HP = 0   // HP shouldn't be negative
    assert(HP >= 0)
  }
  /** Getter of Attack */
  def getAttack: Int = {
    val aux = attack
    aux
  }
  /** Setter of attack */
  def setAttack(increase: Int): Unit = {
    attack += increase
  }
  /** Getter of defense */
  def getDefense: Int = {
    val aux = defense
    aux
  }
  /** Getter of evasion */
  def getEva: Int = {
    val aux = evasion
    aux
  }
  /** Getter of Stars */
  def getStars: Int = {
    val aux = stars
    aux
  }
  /** Setter of stars */
  def setStars(increase: Int): Unit = {
    stars += increase
  }
  /** IsKO is for known quick if an unit can participate in certain activities */
  def IsKO: Boolean = {
    if (getHP == 0) true
    else false
  }
  /** loose determine the amount of star loosed to transfer in a combat */
  def loose: Int

  /** This function choose one option in a set of n options
   *
   * For now it just choose an option using a random criteria
   *
   * @param n Is the amount of option which the player has to pick
   * @return A random option
   */
  def choose(n: Int): Int = {
    val r = new Random(n)
    val random = r.nextInt(n)
    random
  }

  def win(wonStars: Int): Unit = {
    setStars(wonStars)
  }
}
