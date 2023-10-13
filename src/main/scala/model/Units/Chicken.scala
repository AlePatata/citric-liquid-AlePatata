package cl.uchile.dcc.citric.model.Units

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

  def getAttack: Int = {
    val aux = attack
    aux
  }

}