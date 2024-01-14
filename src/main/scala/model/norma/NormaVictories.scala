package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter
/** NormaVictories is type of Norma
 *
 *  This class has as objective the victory goal
 */
class NormaVictories extends AbsNorma {
  protected val achieves: Map[Int, Int] = Map(0 -> 0, 1 -> 0, 2 -> 1, 3 -> 3, 4 -> 6, 5 -> 10, 6 -> 14, 7 -> 999999)

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
    val victories: Int = player.getVictories
    var needed: Int = achieves(level)
    // If the player's victories are more than the expected for his/her actual norma, we check if he/she achieves
    // the requirements for actualize his/her norma
    if (needed <= victories) {
      var n = level
      while (needed <= victories) {
        n += 1
        needed = achieves(n)
      }
      player.NormaClear(n - 1)
    }
  }
}
