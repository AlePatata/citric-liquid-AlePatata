package cl.uchile.dcc.citric
package model

import scala.util.Random

/** The next 3 clases corresponds to kinds of wild units
 *
 */

class Chicken extends WildUnit {
  val maxHp = 3
  val attack = -1
  val defense = -1
  val evasion = 1
  var HP = 3
  var stars = 0
}

class RoboBall extends WildUnit {
  val maxHp = 3
  val attack = -1
  val defense = 1
  val evasion = -1
  var HP = 3
  var stars = 0
}

class Seagull extends WildUnit {
  val maxHp = 3
  val attack = 1
  val defense = -1
  val evasion = -1
  var HP = 3
  var stars = 0
}
