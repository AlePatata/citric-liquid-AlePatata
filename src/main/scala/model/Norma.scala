package cl.uchile.dcc.citric
package model

/** Norma represents the level of a player in the game
 *
 * Corresponds to a set of methods for increase the own norma
 * of a player, and determines when the game is over.
 *
 */
class Norma {
  /** NormaCheck is a method that checks whether or not
   * the necessary objectives to level up a player
   *
   * If the player achives a goal NormaCheck will call
   * NormaClear for actualizy the own norma of th player
   *
   * @param player is the player character thats the NormaChecks will check
   */
  def NormaCheck(player: PlayerCharacter, objective: Stars): Unit = {
    val stars = player.getStars
    if (stars >= 200) {
      NormaClear(6, player)
    }
    else if (stars >= 120) {
      NormaClear(5, player)
    }
    else if (stars >= 70) {
      NormaClear(4, player)
    }
    else if (stars >= 30) {
      NormaClear(3, player)
    }
    else if (stars >= 10) {
      NormaClear(2, player)
    }
  }

  def NormaCheck(player: PlayerCharacter, objective: Victories): Unit = {
    val victories = player.getVictories
    if (victories >= 14) {
      NormaClear(6, player)
    }
    else if (victories >= 10) {
      NormaClear(5, player)
    }
    else if (victories >= 6) {
      NormaClear(4, player)
    }
    else if (victories >= 3) {
      NormaClear(3, player)
    }
    else if (victories >= 1) {
      NormaClear(2, player)
    }
  }

  /** NormaClear modifies the own norma of a player
   *
   * Also NormaClear check if the game is over (when a player has norma = 6)
   *
   * @param n is an integer that corresponds to the level up to modify
   * @param player is the character player to modify
   */
  private def NormaClear(n: Int, player: PlayerCharacter): Unit = {
    player.norma = n
    //if (n == 6)
      //End()  No implemented method for finish a game
  }
}