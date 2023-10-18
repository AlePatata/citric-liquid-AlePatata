package cl.uchile.dcc.citric
package model.units

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

  def getAttack: Int = {
    val aux = attack
    aux
  }
}
