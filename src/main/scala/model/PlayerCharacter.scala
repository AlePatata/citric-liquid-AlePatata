package cl.uchile.dcc.citric
package model

import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHP The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~Your github account~/ ~Your Name~]]
  */
class PlayerCharacter(val name: String,
              val maxHP: Int,
              val attack: Int,
              val defense: Int,
              val evasion: Int,
              val randomNumberGenerator: Random = new Random()) {

  private var HP: Int = maxHP
  private var stars: Int = 1
  private var victories = 0
  var norma = 1
  var objective = new Stars(stars)


  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** This function choose one option in a set of n options
   *
   * For now it just choose the first option, but in here we are
   * going to include the usuar's input/ or another way for pick
   * one or another option in the game
   * @param n Is the amount of option which the player has to pick
   * @return The first option: the integer 0
   */
  def choose(n: Int): Int = {
    0
    /*randomNumberGenerator.nextInt(n)*/
  }

  def getHP: Int = {
    val aux = HP
    aux
  }

  def setHP(increase: Int): Unit = {
    HP + increase
  }

  def getStars: Int = {
    val aux = stars
    aux
  }

  def setStars(increase: Int): Unit = {
    stars + increase
  }

  def getVictories: Int = {
    val aux = victories
    aux
  }

  def setVictories(increase: Int): Unit = {
    victories + increase
  }
}
