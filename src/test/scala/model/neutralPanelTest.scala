package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class neutralPanelTest extends munit.FunSuite {

  private var characters = new ArrayBuffer[PlayerCharacter]()
  private var nextPanels = new ArrayBuffer[Panel]()

  var neutr1: Panel = null
  var neutr2: Panel = null
  var neutr3: Panel = null

  val testPlayer: PlayerCharacter = null

  override def beforeEach(context: BeforeEach): Unit = {
    neutr1 = new neutralPanel(characters, nextPanels, 1)
    neutr2 = new neutralPanel(characters, ArrayBuffer(neutr1), 2)
    neutr3 = new neutralPanel(characters, ArrayBuffer(neutr1), 3)
  }

  test("Equals trivial") {
    val neu: Panel = neutr1
    assertEquals(neutr1, neu)
  }

  test("Equals no trivial") {
    assertNotEquals(neutr2, neutr3)
  }

  test("Add players") {
    val expected = neutralPanel(new ListBuffer(testPlayer), nextPanels, 1)
    assertEquals(neutr1.addCharacter(testPlayer), expected)
  }
}