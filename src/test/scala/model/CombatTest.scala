package cl.uchile.dcc.citric
package model

import model.units.PlayerCharacter

import scala.util.Random

class CombatTest extends munit.FunSuite {

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = new Random(11)

  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    randomNumberGenerator = new Random(11)
  }

  test("A pair of characters should have a combat") {
    val other =
      new PlayerCharacter("otherPlayer", maxHp, attack, defense, evasion, new Random(11))
    val player2 = player
    val other2 = other
    new Combat(player,other)
    new Combat(player2,other2)
    assertEquals(player2.getHP,player.getHP)
    assertEquals(other.getHP,other.getHP)
  }
  test("Player's attack should change") {
    val other =
      new PlayerCharacter("otherPlayer", maxHp, attack, defense, evasion, new Random(11))
    val player2 = player
    val other2 = other
    new Combat(player, other)
    new Combat(player2, other2)
    assertNotEquals(player.getAttack,attack)
    assertEquals(player.getAttack, player2.getAttack)
  }
}
