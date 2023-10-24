package cl.uchile.dcc.citric
package model.units

abstract class AUnits extends Units {
  protected var HP: Int
  protected var attack: Int
  protected var defense: Int
  protected var evasion: Int
  protected var stars: Int

  def getHP: Int = {
    val aux = HP
    aux
  }
  def setHP(increase: Int): Unit = {
    HP += increase
  }
  def getAttack: Int = {
    val aux = attack
    aux
  }
  def setAttack(increase: Int): Unit = {
    attack += increase
  }
  def getDefense: Int = {
    val aux = defense
    aux
  }
  def setDefense(increase: Int): Unit = {
    defense += increase
  }
  def getEva: Int = {
    val aux = evasion
    aux
  }
  def setEva(increase: Int): Unit = {
    evasion += increase
  }
  def getStars: Int = {
    val aux = stars
    aux
  }
  def setStars(increase: Int): Unit = {
    stars += increase
  }
}
