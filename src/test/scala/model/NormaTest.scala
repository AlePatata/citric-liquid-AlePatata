package cl.uchile.dcc.citric
package model

import scala.util.Random

class NormaTest extends munit.FunSuite {

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)


  private var norma = new Norma

  test("NormaCheck and NormaClear") {
    var player = new PlayerCharacter(name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator)
    //player.setStars(120)
    assertEquals(player.norma, 1)
    player.NormaClear(5)
    assertEquals(player.norma, 5)
  }
}
