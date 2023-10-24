package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter

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
   * If the player achieve a goal NormaCheck will call
   * NormaClear for actualizy the own norma of th player
   *
   * @param player is the player character thats the NormaChecks will check
   */
  def NormaCheck(player: PlayerCharacter, objective: Stars): Unit = {
    val stars = player.getStars
    if (stars >= 200) {
      player.NormaClear(6)
    }
    else if (stars >= 120) {
      player.NormaClear(5)
    }
    else if (stars >= 70) {
      player.NormaClear(4)
    }
    else if (stars >= 30) {
      player.NormaClear(3)
    }
    else if (stars >= 10) {
      player.NormaClear(2)
    }
  }

  def NormaCheck(player: PlayerCharacter, objective: Victories): Unit = {
    val victories = player.getVictories
    if (victories >= 14) {
      player.NormaClear(6)
    }
    else if (victories >= 10) {
      player.NormaClear(5)
    }
    else if (victories >= 6) {
      player.NormaClear(4)
    }
    else if (victories >= 3) {
      player.NormaClear(3)
    }
    else if (victories >= 1) {
      player.NormaClear(2)
    }
  }

  /** NormaClear modifies the own norma of a player
   *
   * Also NormaClear check if the game is over (when a player has norma = 6)
   *
   * @param n is an integer that corresponds to the level up to modify
   * @param player is the character player to modify
   */
  /*def NormaClear(n: Int, player: PlayerCharacter): Unit = {
    player.norma = n
    //if (n == 6)
      //End()  No implemented method for finish a game
  }*/
}