package cl.uchile.dcc.citric
package controller

import controller.GameController


class ControllerTest extends munit.FunSuite{
  test("Controller should start a game") {
    val control = new GameController
    control.startGame()
    //testear output?
  }
}
