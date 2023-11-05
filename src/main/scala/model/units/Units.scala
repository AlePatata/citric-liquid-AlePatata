package cl.uchile.dcc.citric
package model.units

/** Is the specifications of methods that an unit should had
 *
 */
trait Units {
  /**Getters and Setters
  * @see AUnits
  */
  def getHP: Int

  /** Getters and Setters
   * @see AUnits
   */
  def setHP(increase: Int): Unit

  /** Getters and Setters
   *
   * @see AUnits
   */
  def getDefense: Int

  /** Getters and Setters
   *
   * @see AUnits
   */
  def getEva: Int
  def getStars: Int
  def setStars(increase: Int): Unit

  /** Getters and Setters
   *
   * @see AUnits
   */
  def getAttack: Int

  /** IsKO verifies if the unit still alive
   *
   * @return true if HP isn't 0, false in the other case
   */
  def IsKO: Boolean
  def choose(n: Int): Int
  def loose: Int
}
