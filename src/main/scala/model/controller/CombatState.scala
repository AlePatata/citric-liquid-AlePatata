package cl.uchile.dcc.citric
package model.controller

class CombatState extends AState {
  def endCombat(): Unit = {
    val s: State = new LandingPanel
    controller.changeState(s)
    s.controller = controller

    println("Landing Panel\n")
  }
}
