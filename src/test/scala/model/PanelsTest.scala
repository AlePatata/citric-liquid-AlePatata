package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelsTest extends munit.FunSuite {

  private var characters = new ArrayBuffer[PlayerCharacter]()
  private var nextPanels = new ArrayBuffer[Panel]()

  var pan1: Panel = _
  var pan2: Panel = _
  var pan3: Panel = _



  test("Equals bonusPanel") {
    pan1 = new bonusPanel(characters, nextPanels, 1)
    pan2 = new bonusPanel(characters, ArrayBuffer(pan1), 2)
    pan3 = new neutralPanel(characters, ArrayBuffer(pan1), 2)
    assertNotEquals(pan1, pan2)
    assertNotEquals(pan2, pan3)
    assertNotEquals(pan1, pan3)
  }

  test("Equals dropPanel") {
    pan1 = new dropPanel(characters, nextPanels, 1)
    pan2 = new dropPanel(characters, ArrayBuffer(pan1), 2)
    pan3 = new dropPanel(characters, ArrayBuffer(pan1), 2)
    assertNotEquals(pan1, pan2)
    assertEquals(pan2, pan3)
    assertNotEquals(pan1, pan3)
  }

  test("Equals homePanel") {
    pan1 = new homePanel(characters, nextPanels, 1)
    pan2 = new homePanel(characters, ArrayBuffer(pan1), 2)
    pan3 = new homePanel(characters, ArrayBuffer(pan1), 2)
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

  /*
  test("Effects") {
    pan1 = new dropPanel(characters, nextPanels, 1)
    pan1.effect(player)
    assertEquals(player.stars, )
  }
  */
}