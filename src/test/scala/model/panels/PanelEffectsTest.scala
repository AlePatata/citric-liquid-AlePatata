package cl.uchile.dcc.citric
package model.panels

import model.panels.{BonusPanel, DropPanel, EncounterPanel, HomePanel, NeutralPanel, Panel}
import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelEffectsTest extends munit.FunSuite {

  private val characters = new ArrayBuffer[PlayerCharacter]()
  private val nextPanels = new ArrayBuffer[Panel]()

  var pan1: Panel = _
  var pan2: Panel = _

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = _

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


  test("Efecto de NeutralPanel") {
    pan1 = new NeutralPanel(characters, nextPanels)
    val player1 = player
    pan1.apply(player)
    assertEquals(player, player1)
  }

  test("Efecto de HomePanel") {
    pan1 = new HomePanel(characters, nextPanels)
    pan1.apply(player)
    assertEquals(player.getNorma.getLevel, 1)
    player.setStars(29)
    pan1.apply(player)
    assertEquals(player.getNorma.getLevel, 3)
    player.setStars(120)
    pan1.apply(player)
    assertEquals(player.getNorma.getLevel, 5)
  }
  test("Efecto de HomePanel con objetivo de Victorias") {
    player.setNorma(player.ChooseObjective("victories"))
    pan1 = new HomePanel(characters, nextPanels)
    pan1.apply(player)
    assertEquals(player.getNorma.getLevel, 1)
    player.setVictories(6)
    pan1.apply(player)
    assertEquals(player.getNorma.getLevel, 4)
  }

  test("Efecto BonusPanel") {
    pan1 = new BonusPanel(characters, nextPanels)
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    pan1.apply(player)
    pan1.apply(other)

    assertEquals(player.getStars, other.getStars)

  }
  test("Efecto DropPanel") {
    pan1 = new DropPanel(characters, nextPanels)
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    pan1.apply(player)
    pan1.apply(other)

    assertEquals(player.getStars, other.getStars)
  }
  test("Efecto EncounterPanel") {
    pan1 = new EncounterPanel(characters, nextPanels)
    pan2 = new EncounterPanel(characters, nextPanels)
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    pan1.apply(player)
    pan2.apply(other)
    assertEquals(player.getVictories,other.getVictories)
    assertEquals(player.getStars, other.getStars)
  }
}