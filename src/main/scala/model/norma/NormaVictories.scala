package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter

class NormaVictories extends AbsNorma {
  protected val achieves: Map[Int, Int] = Map(2 -> 1, 3 -> 3, 4 -> 6, 5 -> 10, 6 -> 14)

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
    if (needed < victories) {
      var n = level
      while (needed < victories) {
        needed = achieves(n)
        n += 1
      }
      player.NormaClear(n)
    }
  }
}
