package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PartidaTest extends munit.FunSuite {

  private var panel: Panel = _

  private var character = new PlayerCharacter(val name = "testPlayer",
  val maxHp = 10,
  val attack = 1,
  val defense = 1,
  val evasion = 1,
  val randomNumberGenerator = new Random(11))

  private var characters = new ArrayBuffer[PlayerCharacter]()
  private var nextPanels = new ArrayBuffer[Panel]()

  override def beforeEach(contet: BeforeEach): Unit = {
    panel = new bonusPanel(characters, nextPanels)
  }
}