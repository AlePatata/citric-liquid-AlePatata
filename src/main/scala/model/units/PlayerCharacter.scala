package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.controller.Observer
import cl.uchile.dcc.citric.model.norma.{Norma, NormaStars, NormaVictories}

import scala.collection.mutable.ArrayBuffer
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
  * @param Attack The player's capability to deal damage to opponents.
  * @param Defense The player's capability to resist or mitigate damage from opponents.
  * @param Evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/AlePatata/ Alejandra Campos Urbina]]
  */
class PlayerCharacter(val name: String,
              val maxHP: Int,
              val Attack: Int,
              val Defense: Int,
              val Evasion: Int,
              val randomNumberGenerator: Random = new Random())
  extends AUnits{

  protected var HP: Int = maxHP
  protected var stars: Int = 1
  protected var attack: Int = Attack
  protected var defense: Int = Defense
  protected val evasion: Int = Evasion
  private var victories: Int = 0
  private var norma: Norma = ChooseObjective()
  val observers = ArrayBuffer[Observer]()

  /** This is a provisional method that choose an objective for the player
   *
   * @param obj string that indicates the objective of the player in his/her turn
   * @return the norma depending on the type
   */
  def ChooseObjective(obj: String = "stars"): Norma = {
    var objective: Norma = new NormaStars
    if(obj == "victories"){
      objective = new NormaVictories
    }
    objective
  }
  /** Setter of the player's Norma and his/her possible objective */
  def setNorma(n: Norma): Unit = {
    norma = n
  }

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** This function choose one option in a set of n options
   *
   * For now it just choose the first option, but in here we are
   * going to include the user's input/ or another way for pick
   * one or another option in the game
   * @param n Is the amount of option which the player has to pick
   * @return The first option: the integer 0
   */
  override def choose(n: Int): Int = {
    0
    /*randomNumberGenerator.nextInt(n)*/
  }

  /** NormaClear modifies the own norma of a player
   *
   * @param n is an integer that corresponds to the level up to modify
   */
  def NormaClear(n: Int): Unit = {
    norma.setLevel(n)
    if (norma.getLevel >= norma.maxlevel) notifyObservers()
  }
  /** Setter of victories */
  def setVictories(increase: Int): Unit = {
    victories += increase
  }
  /** Getter of victories */
  def getVictories: Int = {
    val aux = victories
    aux
  }
  /** Getter of norma */
  def getNorma: Norma = {
    val aux = norma
    aux
  }

  /** In a combat this function modified the stars that the player loose
   *
   * @return The amount of stars that loosed
   */
  def loose: Int = {
    val stars = this.getStars/2
    this.setStars(-stars)
    val Loose = stars
    Loose
  }

  /** In a combat this function modified the victories that the player win
   *
   */
  def win(wonStars: Int, Victories: Int): Unit = {
    setStars(wonStars)
    setVictories(Victories)
  }

  def notifyObservers(): Unit = {
    for (o <- observers) {
      o.update()
    }
  }

}
