package cl.uchile.dcc.citric
package model.combat

import model.units.{Chicken,RoboBall,Seagull, PlayerCharacter}

import scala.util.Random

class WildCombatTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = _


  private var player: PlayerCharacter = new PlayerCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator)

  test("A Wild Unit should respawn if it loose the combat") {
    player.setAttack(999999)
    val seagull = new Seagull
    val HP = seagull.getHP
    val stars = seagull.getStars
    new WildCombat(player,seagull)
    assertEquals(HP,seagull.getHP)
    assertEquals(stars,seagull.getStars)
  }
}
