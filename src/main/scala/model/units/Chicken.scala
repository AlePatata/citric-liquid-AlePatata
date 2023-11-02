package cl.uchile.dcc.citric.model.units

class Chicken extends AUnits with WildUnit {
  protected var HP: Int = 3
  protected var attack: Int = -1
  protected var defense: Int = -1
  protected var stars: Int = 0
  protected val evasion: Int = 1

  def getBonus: Int = 3

}