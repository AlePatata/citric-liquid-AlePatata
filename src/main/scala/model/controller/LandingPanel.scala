package cl.uchile.dcc.citric
package model.controller

class LandingPanel extends AState {
  def doEffect(): Unit = {
    val s: State = ChapterState
    controller.changeState(s)
    s.controller = controller


    println("New Round\n")
  }
}
