package cl.uchile.dcc.citric
package controller

class Observer {
  private var controller: Option[GameController] = None

  def update(): Unit = {
    if(controller.isDefined)
      controller.get.endGame()
    else throw new AssertionError("There is no controller defined")
  }

  def getController(): GameController = {
    if (controller.isDefined)
      controller.get
    else throw new AssertionError("There is no controller defined")
  }

  def setController(c: GameController): Unit = {
    controller = Some(c)
  }
}
