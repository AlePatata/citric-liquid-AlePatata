package cl.uchile.dcc.citric
package model.paneltests

import model.panels.{BonusPanel, DropPanel, HomePanel, NeutralPanel, Panel}
import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelsTest extends munit.FunSuite {

  private var characters = new ArrayBuffer[PlayerCharacter]()
  private var nextPanels = new ArrayBuffer[Panel]()

  var pan1: Panel = _
  var pan2: Panel = _
  var pan3: Panel = _

  test("Equals BonusPanel") {
    pan1 = new BonusPanel(characters, nextPanels)
    pan2 = new BonusPanel(characters, ArrayBuffer(pan1))
    pan3 = new NeutralPanel(characters, ArrayBuffer(pan1))
    assertNotEquals(pan1, pan2)
    assertNotEquals(pan2, pan3)
    assertNotEquals(pan1, pan3)
  }

  test("Equals DropPanel") {
    pan1 = new DropPanel(characters, nextPanels)
    pan2 = new DropPanel(characters, ArrayBuffer(pan1))
    pan3 = pan2
    assertNotEquals(pan1, pan2)
    assertEquals(pan2, pan3)
    assertNotEquals(pan1, pan3)
  }

  test("Equals HomePanel") {
    pan1 = new HomePanel(characters, nextPanels)
    val nextPanels2 = new ArrayBuffer[Panel]
    pan2 = new HomePanel(characters, nextPanels2)
    pan3 = pan2
    assertNotEquals(pan1, pan2)
    assertEquals(pan2, pan3)
    assertNotEquals(pan1, pan3)
  }

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

  test("Añadir Jugadores") {
    pan1 = new NeutralPanel(characters, nextPanels)
    val characters1: ArrayBuffer[PlayerCharacter] = characters
    characters1 += player
    pan1.addCharacter(player)
    assertEquals(characters1,characters)
  }

  test("Remover Jugadores") {
    val characters1: ArrayBuffer[PlayerCharacter] = characters
    characters1 += player
    pan1 = new NeutralPanel(characters1, nextPanels)
    pan1.removeCharacter(player)
    assertEquals(characters1, characters)
  }

  test("Añadir Paneles") {
    pan1 = new NeutralPanel(characters, nextPanels)
    pan2 = new NeutralPanel(characters, nextPanels)
    val panels: ArrayBuffer[Panel] = nextPanels
    panels += pan2
    pan1.addPanel(pan2)
    assertEquals(pan1.nextPanels, panels)
  }

  test("Remover Paneles") {
    val panels = ArrayBuffer[Panel](pan2)
    pan1 = new NeutralPanel(characters, panels)
    pan2 = new NeutralPanel(characters, nextPanels)
    panels -= pan2

    pan1.removePanel(pan2)
    assertEquals(pan1.nextPanels, panels)
  }



  
}