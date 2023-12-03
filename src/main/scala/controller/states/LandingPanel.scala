package cl.uchile.dcc.citric
package controller.states

class LandingPanel extends AState {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel()
  def doEffect(): Unit = {
    val s: State = controller.getChapter()
    controller.changeState(s)
    s.controller = controller
    panel(player)

    println("New Round\n")
  }
}
