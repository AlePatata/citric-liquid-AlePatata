package scala.model

import scala.util.Random

class NormaTest extends munit.FunSuite {

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator: Random = null

  private var player = new PlayerCharacter(name,
    maxHp,
    attack,
    defense,
    evasion,
    randomNumberGenerator)

  private var norma = new Norma

  test("NormaCheck") {
    assertEquals(player.norma, 1)
    player.stars = 120
    norma.NormaCheck(player)
    assertEquals(player.norma, 5)
  }
}
