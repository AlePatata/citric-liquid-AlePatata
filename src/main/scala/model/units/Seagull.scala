package cl.uchile.dcc.citric
package model.units

class Seagull extends AUnits with WildUnit {
  protected var HP = 3
  protected var attack = 1
  protected var defense: Int = -1
  protected var stars = 0
  protected val evasion: Int = -1

  def getBonus: Int = 2
}