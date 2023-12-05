package cl.uchile.dcc.citric
package controller.states

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.panels.Panel

class ChapterState(var chapter: Int, c: GameController) extends AState(c: GameController) {
  private val maxChapter = controller.maxChapter
  val mapa: List[Panel] = controller.tablero.mapa

  if (chapter >= maxChapter) {
    controller.endGame()
  }
  for ((t,p: PlayerCharacter) <- controller.turns) {
    giveStars(p)
    controller.setCurrentPlayer(p)
    controller.setCurrentPanel(mapa(t))
    if (p.IsKO) {
      isKO(p)
    } else playTurn(p)
  }


  def isKO(player: PlayerCharacter): Unit = {
    val s: State = new Recovery(player,controller)
    controller.changeState(s)
    s.controller = controller

    println(s"${player.name} has entered in a Recovery State\n")
  }

  def playTurn(player: PlayerCharacter): Unit = {
    controller.changeState(new PlayerTurn(player,controller))

    println(s"${player.name}'s Turn\n")
  }

  def giveStars(player: PlayerCharacter): Unit = {
    player.setStars( 1 + controller.getChapter()/5 )
  }

}
