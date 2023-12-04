package cl.uchile.dcc.citric
package observer

import controller.GameController

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class ObserverTest extends munit.FunSuite {
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

  }




  test("observer should notify to controller") {
    controller.addPlayer(player)
    controller.startGame()
    assert(!controller.finish)
    player.NormaClear(6)
    assert(controller.finish)
  }
}
