package cl.uchile.dcc.citric
package controller

import controller.GameController


class ControllerTest extends munit.FunSuite{
  val controller = new GameController
  test("Controller should start and finish a game") {
    assert(controller.finish)
    controller.startGame()
    assert(!controller.finish)
    controller.endGame()
    assert(controller.finish)
  }
}
