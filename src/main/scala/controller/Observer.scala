package cl.uchile.dcc.citric
package controller

/** Observer is the class in charge which notifies to the controller id the norma six is reached
 *
 */
class Observer {
  private var controller: Option[GameController] = None
  /** Notifies to the controller if the condition is achieved */
  def update(): Unit = {
    if(controller.isDefined)
      controller.get.endGame()
    else throw new AssertionError("There is no controller defined")
  }

  /** Setter of the controller */
  def setController(c: GameController): Unit = {
    controller = Some(c)
  }
}
