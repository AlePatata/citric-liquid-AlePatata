package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.Panels.neutralPanel
import cl.uchile.dcc.citric.model.Units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class neutralPanelTest extends munit.FunSuite {

  private var characters = new ArrayBuffer[PlayerCharacter]()
  private var nextPanels = new ArrayBuffer[Panel]()

  var neutr1: Panel = _
  var neutr2: Panel = _
  var neutr3: Panel = _

  val testPlayer: PlayerCharacter = null

  override def beforeEach(context: BeforeEach): Unit = {
    neutr1 = new neutralPanel(characters, nextPanels)
    neutr2 = new neutralPanel(characters, ArrayBuffer(neutr1))
    neutr3 = new neutralPanel(characters, ArrayBuffer(neutr1))
  }

  test("Equals trivial") {
    val neu: Panel = neutr1
    assertEquals(neutr1, neu)
  }

  test("Equals no trivial") {
    assertNotEquals(neutr2, neutr3)
  }

  test("Add players") {
    characters += testPlayer
    val expected = new neutralPanel(characters, nextPanels)
    neutr1.addCharacter(testPlayer)
    assertEquals(neutr1.characters, expected.characters)
  }
}