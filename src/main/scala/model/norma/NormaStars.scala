package cl.uchile.dcc.citric
package model.norma
import model.units.PlayerCharacter

/** NormaStars is type of Norma
 *
 *  This class has as objective the stars goal
 */

class NormaStars extends AbsNorma {
  /** The map in where the achievements are saved
   */
  protected val achieves: Map[Int, Int] = Map(1 -> 0, 2 -> 10, 3 -> 30, 4 -> 70, 5 -> 120, 6 -> 200, 7 -> 9999999)

  /** NormaCheck is a method that checks whether or not
   * the necessary objectives to level up a player
   *
   * If the player achieve a goal NormaCheck will call
   * NormaClear for actualize the own norma of th player
   *
   * @param player is the player character that the NormaChecks will check
   */

  def NormaCheck(player: PlayerCharacter): Unit = {
    val norma: Norma = player.getNorma
    val level: Int = norma.getLevel
    val stars: Int = player.getStars
    var needed: Int = achieves(level)
    // If the player's stars are more than the expected for his/her actual norma, we check if he/she achieves
    // the requirements for actualize his/her norma
    if (needed <= stars) {
      var n = level
      while (needed <= stars) {
        n += 1
        needed = achieves(n)
      }
      player.NormaClear(n-1)
    }
  }
}