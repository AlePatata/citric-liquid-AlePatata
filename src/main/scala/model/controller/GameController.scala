package cl.uchile.dcc.citric
package model.controller

class GameController {
  private var state: State = _

  def changeState(s: State) = {
    state = s
  }

  def startGame() = {
    val s: State = new PreGame
    changeState(s)
    s.controller = this

    println("Start Game\n")
  }

  def endGame(): Unit = {
    changeState(new EndGame)
    println("End Game\n")
  }
}
