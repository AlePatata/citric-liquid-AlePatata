package cl.uchile.dcc.citric
package controller.states

import model.units.PlayerCharacter

class ChapterState(var chapter: Int) extends AState {
  val maxchapter = 4
  if (chapter >= maxchapter) {
    controller.endGame()
  }
  def newChapter() : Unit = {
    chapter += 1
  }
  def normaSixReached(): Unit = {
    val s: State = new EndGame
    controller.changeState(s)
    s.controller = controller

    println("End Game\n")
  }

  def isKO(playerCharacter: PlayerCharacter): Unit = {
    val s: State = new Recovery
    controller.changeState(s)
    s.controller = controller

    println("Recovery State\n")
  }

  def playTurn(character: PlayerCharacter): Unit = {
    val s: State = new PlayerTurn(character)
    controller.changeState(s)
    s.controller = controller

    println("Player Turn\n")
  }
}
