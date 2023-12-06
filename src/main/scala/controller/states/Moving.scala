package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import scala.util.Random
/** Class in charge of change the position and choose the next panel for the player to move */
class Moving(var roll: Int,c: GameController) extends AState(c: GameController) {
  val player = controller.getCurrentPlayer()
  var panel = controller.getCurrentPanel(player)
  val Choose = new Random(13)


  move()
  /** Moves the player to the next panel
   * If there is a HomePanel and depending of a provisional input (random choose) the player could select if
   * they want to stop moving and landing before finish the number of their dice */
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
  /** Checks if the HomePanel is of the current player property */
  def isMyHomePanel(): Boolean = {
    if(player.home.isDefined) {
      val home = player.home.get
      if(panel == home) {
        true
      } else false
    } else false
  }
  /** Change the state to begin a combat state */
  private def outOfMovements(): Unit = {
    controller.changeState(new CombatState(controller))

    println("Starting a Combat\n")
  }
  /** Picks the actual panel to actualize the current panel of the player */
  def choosePath(): Unit = {
    roll = 0
    outOfMovements()
  }
  /** Keeps moving to a panel in the nextPanels actual panel's list
   *
   * It also choose a random option in the list of possibles nextPanels */
  def nextPanel(): Unit = {
    val siguientes = panel.nextPanels
    controller.setCurrentPanel(siguientes(Choose.nextInt(siguientes.length)))
    roll -= 1
  }
}
