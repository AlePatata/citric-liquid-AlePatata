package cl.uchile.dcc.citric
package model

trait Units{
  def getHP: Int
  def setHP(increase: Int): Unit
  def getDefense: Int
}
trait WildUnit extends Units

/** The next 3 classes corresponds to kinds of wild units
 *
 */

class Chicken extends WildUnit {
  private val attack: Int = -1
  val defense: Int = -1
  val evasion: Int = 1
  private var HP: Int = 3
  private var stars: Int = 0

  def setHP(increase: Int): Unit = {
    HP += increase
  }

  def getHP: Int = {
    val aux = HP
    aux
  }

  def setStars(increase: Int): Unit = {
    stars += increase
  }

  def getDefense: Int = {
    val aux = defense
    aux
  }

}

class RoboBall extends WildUnit {
  private val attack: Int = -1
  val defense = 1
  val evasion: Int = -1
  private var HP: Int = 3
  private var stars: Int  = 0

  def setHP(increase: Int): Unit = {
    HP += increase
  }

  def getHP: Int = {
    val aux = HP
    aux
  }

  def getStars: Int = {
    val aux = stars
    aux
  }

  def setStars(increase: Int): Unit = {
    stars += increase
  }

  def getDefense: Int = {
    val aux = defense
    aux
  }
}

class Seagull extends WildUnit {
  private val attack = 1
  val defense: Int = -1
  val evasion: Int = -1
  private var HP = 3
  private var stars = 0

  def setHP(increase: Int): Unit = {
    HP += increase
  }

  def getHP: Int = {
    val aux = HP
    aux
  }

  def getStars: Int = {
    val aux = stars
    aux
  }

  def setStars(increase: Int): Unit = {
    stars += increase
  }

  def getDefense: Int = {
    val aux = defense
    aux
  }
}
