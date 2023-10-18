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
  private val randomNumberGenerator: Random = null

  private var player = new PlayerCharacter(name,
    maxHp,
    attack,
    defense,
    evasion,
    randomNumberGenerator)

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
  test("Efecto de NeutralPanel") {
      pan1 = new NeutralPanel(characters, nextPanels)
      val player1 = player
      pan1.apply(player)
      assertEquals(player, player1)
    }
  test("Efecto de HomePanel") {
    pan1 = new HomePanel(characters, nextPanels)
    pan1.apply(player)
    assertEquals(player.norma, 1)
    player.setStars(200)
    pan1.apply(player)
    assertEquals(player.norma, 6)
  }
  
  /*test("Effects") {
    pan1 = new DropPanel(characters, nextPanels)
    val stars = player.getStars
    pan1.apply(player)
    assertNotEquals(player.getStars, stars)
  }*/
  
}