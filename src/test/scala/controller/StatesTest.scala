package cl.uchile.dcc.citric
package controller

import model.units.PlayerCharacter
import scala.util.Random

class StatesTest extends munit.FunSuite {
  val controller = new GameController

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

    controller.addPlayer(player)
  }


  test("PreGame should sort the turns") {
    assert(controller.turns.isEmpty)
    val c: GameController = controller
    controller.startGame()
    c.startGame()
    assertEquals(controller.turns,c.turns)
  }

  test("ChapterState should end when chapter is 4") {
    assertEquals(controller.getChapter(),1)
    controller.startGame()
    controller.startRounds()
    assertEquals(controller.getChapter(),controller.maxChapter)
  }
}
