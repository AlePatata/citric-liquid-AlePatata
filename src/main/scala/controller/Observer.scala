package cl.uchile.dcc.citric
package controller

class Observer {
  var controller: GameController = _


  def update(): Unit = {
    controller.endGame()
  }
}
