package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import scala.util.Random

class Moving(var roll: Int,c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel(player)
  val Choose = new Random(13)


  move()

  def move() = {
    if (isMyHomePanel()) {
      val choose = Choose.nextInt(2)
      if(choose == 0) choosePath()
      else nextPanel()
    }
    else {
      while(roll != 0) {
        nextPanel()
      }
      choosePath()
    }
  }

  def isMyHomePanel(): Boolean = {
    if(player.home.isDefined) {
      val home = player.home.get
      if(panel == home) {
        true
      } else false
    } else false
  }
  private def outOfMovements(): Unit = {
    controller.changeState(new CombatState(controller))

    println("Starting a Combat\n")
  }

  def choosePath(): Unit = {
    roll = 0
    outOfMovements()
  }
  def nextPanel(): Unit = {
    val siguientes = panel.nextPanels
    controller.setCurrentPanel(siguientes(player.choose(siguientes.length)))
    roll -= 1
  }
}
