package cl.uchile.dcc.citric
package controller.states

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.panels.Panel

/** Class which represents the abstract idea of a round in the game
 *
 * @param chapter number of actual chapter(round)
 * @param c controller
 */
class ChapterState(var chapter: Int, c: GameController) extends AState(c: GameController) {
  private val maxChapter = controller.maxChapter
  val mapa: List[Panel] = controller.tablero.mapa
  /** Condition of max rounds to finish the game */
  if (chapter >= maxChapter) {
    controller.endGame()
  }
  /** Starts the cycle of one round, giving each player a turn and assigns an predefined amount of stars*/
  for ((t,p: PlayerCharacter) <- controller.turns) {
    giveStars(p)
    controller.setCurrentPlayer(p)
    controller.setCurrentPanel(mapa(t))
    if (p.IsKO) {
      isKO(p)
    } else playTurn(p)
  }

  /** Checks the condition to play a turn */
  def isKO(player: PlayerCharacter): Unit = {
    controller.changeState(new Recovery(player,controller))

    println(s"${player.name} has entered in a Recovery State\n")
  }
  /** Change the controller state to play turn */
  def playTurn(player: PlayerCharacter): Unit = {
    controller.changeState(new PlayerTurn(player,controller))

    println(s"${player.name}'s Turn\n")
  }
  /** Defines the amount of stars to assign to each player in their respective turn */
  def giveStars(player: PlayerCharacter): Unit = {
    player.setStars( 1 + controller.getChapter()/5 )
  }

}
