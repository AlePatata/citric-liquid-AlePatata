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
  test("Half of stars of the looser should transfer to the winner") {
    val other =
      new PlayerCharacter("otherPlayer", 1, attack, 0, evasion, new Random(11))
    other.setStars(7)
    val otherStars = other.getStars
    val stars = player.getStars
    new Combat(player, other)
    assertEquals(player.getStars, stars + 4)
    assertEquals(other.getStars, otherStars/2)
  }
  test("Winner should receive victories") {
    val other =
      new PlayerCharacter("otherPlayer", 1, attack, 0, evasion, new Random(11))
    val otherVictories = other.getVictories
    val victories = player.getVictories
    new Combat(player, other)
    assertEquals(player.getVictories, victories + 2)
    assertEquals(other.getVictories, otherVictories)
  }
}
