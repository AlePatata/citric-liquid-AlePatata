package cl.uchile.dcc.citric
package model.controller

import model.units.PlayerCharacter

object ChapterState extends AState {
  var chapter: Int = 1
  override def newChapter() : Unit = {
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
