package cl.uchile.dcc.citric
package model.units

trait Units {
  def getHP: Int
  def setHP(increase: Int): Unit
  def getDefense: Int
  def getStars: Int
  def setStars(increase: Int): Unit
  def getAttack: Int
  def IsKO: Boolean
}
