package cl.uchile.dcc.citric
package model.controller

class Moving(var roll: Int) extends AState {
  def StopMovement(): Unit = {
    roll = 0
  }

  private def outOfMovements(): Unit = {
    val s: State = new CombatState
    controller.changeState(s)
    s.controller = controller

    println("Start A Combat\n")
  }

  def choosePath(): Unit = {}

  if(roll == 0) outOfMovements()
}
